package com.asaas.docs.client;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.dto.request.DocumentRequestDTO;
import com.asaas.docs.dto.response.DocumentResponseDTO;
import com.asaas.docs.enums.DocumentType;
import com.asaas.docs.exception.AsaasApiException;
import com.asaas.docs.exception.AsaasErrorResponse;
import com.asaas.docs.util.AsaasUtil;
import com.google.gson.Gson;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Arrays;

public class BaseClient {

    private static final HttpClient client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    private static final Gson gson = new Gson();

    @SneakyThrows
    public static String getRequest(String service, String query) {

        var uri = new URI(AsaasApiConfig.BASE_URL() + service + (query != null ? query : ""));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("access_token", AsaasApiConfig.getApiKey())
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        verifyErrorApiAsaas(response);

        return response.body();
    }

    @SneakyThrows
    public static String postRequest(String service, String json) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(AsaasApiConfig.BASE_URL() + service))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("access_token", AsaasApiConfig.getApiKey())
                .POST(HttpRequest.BodyPublishers.ofString(json != null ? json : "{}", StandardCharsets.UTF_8))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        verifyErrorApiAsaas(response);

        return response.body();
    }

    @SneakyThrows
    public static String postRequestMultipartFormData(String service, String json, Path path, String name, Class classe) {

        var uploadRequest = gson.fromJson(json, classe);

        HttpRequest.BodyPublisher bodyPublisher = createMultipartBody(path, uploadRequest, name);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(AsaasApiConfig.BASE_URL() + service))
                .header("Content-Type", "multipart/form-data; boundary=---011000010111000001101001")
                .header("Accept", "application/json")
                .header("access_token", AsaasApiConfig.getApiKey())
                .POST(bodyPublisher)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        verifyErrorApiAsaas(response);

        return response.body();
    }

    @SneakyThrows
    public static String putRequest(String service, String json) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(AsaasApiConfig.BASE_URL() + service))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("access_token", AsaasApiConfig.getApiKey())
                .PUT(HttpRequest.BodyPublishers.ofString(json != null ? json : "{}", StandardCharsets.UTF_8))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        verifyErrorApiAsaas(response);

        return response.body();
    }

    @SneakyThrows
    public static String deleteRequest(String service, String query) {

        var uri = new URI(AsaasApiConfig.BASE_URL() + service + (query != null ? query : ""));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("access_token", AsaasApiConfig.getApiKey())
                .DELETE()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        verifyErrorApiAsaas(response);

        return response.body();
    }

    public static String deleteRequest(String service) {
        return deleteRequest(service, null);
    }

    private static HttpRequest.BodyPublisher createMultipartBody(@NonNull Path filePath, @NonNull Object request, String name) throws IOException {

        String contentType = Files.probeContentType(filePath);

        String filePartHeader = "-----011000010111000001101001\r\n"
                + "Content-Disposition: form-data; name=\"" + name + "\"; filename=\"" + filePath.getFileName() + "\"\r\n"
                + "Content-Type: "+ contentType +"\r\n\r\n";
        String multipartBodyResult = multipartBody(request);
        String endBoundary = "-----011000010111000001101001--\r\n";

        // Lê o conteúdo do arquivo
        byte[] fileContent = java.nio.file.Files.readAllBytes(filePath);

        // Concatena todas as partes
        byte[] multipartBody = concatenateBytes(
                multipartBodyResult.getBytes(StandardCharsets.UTF_8),
                filePartHeader.getBytes(StandardCharsets.UTF_8),
                fileContent,
                "\r\n".getBytes(StandardCharsets.UTF_8),
                endBoundary.getBytes(StandardCharsets.UTF_8)
        );

        HttpRequest.BodyPublisher bodyPublisher = HttpRequest.BodyPublishers.ofByteArray(multipartBody);
        return bodyPublisher;
    }

    @SneakyThrows
    private static String multipartBody(@NonNull Object object) {
        StringBuilder builder = new StringBuilder();

        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            builder.append("-----011000010111000001101001\n");
            builder.append("Content-Disposition: form-data; name=\""+ field.getName() +"\"\r\n\r\n" + field.get(object) + "\r\n");
        }

        return builder.toString();
    }

    private static byte[] concatenateBytes(byte[]... arrays) {
        int length = Arrays.stream(arrays).mapToInt(array -> array.length).sum();
        byte[] result = new byte[length];
        int pos = 0;
        for (byte[] array : arrays) {
            System.arraycopy(array, 0, result, pos, array.length);
            pos += array.length;
        }
        return result;
    }

    private static void verifyErrorApiAsaas(HttpResponse<String> response) {
        if (response.statusCode() != 200 && response.statusCode() != 201) {

            if (response.statusCode() == 401) {
                throw new AsaasApiException("Erro 401: Não Autorizado na API da Asaas Pagamento (Verifique se sua API_KEY está inserida corretamente ou se está expirada).");
            }

            String body = response.body();

            if (body != null && body.contains("errors")) {
                AsaasErrorResponse errorResponse = gson.fromJson(response.body(), AsaasErrorResponse.class);
                if (!AsaasUtil.isEmpty(errorResponse.getErrors())) {
                    throw new AsaasApiException(errorResponse);
                }
            } else {
                throw new AsaasApiException("Erro interno na API da Asaas Pagamento: \n\n" + body);
            }
        }
    }

}
