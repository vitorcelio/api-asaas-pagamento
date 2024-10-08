package com.asaas.docs.client;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.exception.AsaasApiException;
import com.asaas.docs.exception.AsaasErrorResponse;
import com.asaas.docs.util.AsaasUtil;
import com.google.gson.Gson;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

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

        if(response.statusCode() != 200 && response.statusCode() != 201) {
            AsaasErrorResponse errorResponse = gson.fromJson(response.body(), AsaasErrorResponse.class);
            if (!AsaasUtil.isEmpty(errorResponse.getErrors())) {
                throw new AsaasApiException(errorResponse);
            }
        }

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

        if(response.statusCode() != 200 && response.statusCode() != 201) {
            AsaasErrorResponse errorResponse = gson.fromJson(response.body(), AsaasErrorResponse.class);
            if (!AsaasUtil.isEmpty(errorResponse.getErrors())) {
                throw new AsaasApiException(errorResponse);
            }
        }

        return response.body();
    }

    @SneakyThrows
    public static String deleteRequest(String service) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(AsaasApiConfig.BASE_URL() + service))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("access_token", AsaasApiConfig.getApiKey())
                .DELETE()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if(response.statusCode() != 200 && response.statusCode() != 201) {
            AsaasErrorResponse errorResponse = gson.fromJson(response.body(), AsaasErrorResponse.class);
            if (!AsaasUtil.isEmpty(errorResponse.getErrors())) {
                throw new AsaasApiException(errorResponse);
            }
        }

        return response.body();
    }

}
