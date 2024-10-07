package com.asaas.docs.client;

import com.asaas.docs.configuration.AsaasApiConfig;
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

    @SneakyThrows
    public static String getRequest(String service, String... params) {

        var uri = new URI(AsaasApiConfig.BASE_URL() + service);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", AsaasApiConfig.getApiKey())
                .headers(params)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    @SneakyThrows
    public static String postRequest(String service, String json, String... params) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(AsaasApiConfig.BASE_URL() + service))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("access_token", AsaasApiConfig.getApiKey())
                .headers(params)
                .POST(HttpRequest.BodyPublishers.ofString(json != null ? json : "{}", StandardCharsets.UTF_8))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    @SneakyThrows
    public static String putRequest(String service, String json, String... params) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(AsaasApiConfig.BASE_URL() + service))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("access_token", AsaasApiConfig.getApiKey())
                .headers(params)
                .PUT(HttpRequest.BodyPublishers.ofString(json != null ? json : "{}", StandardCharsets.UTF_8))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    @SneakyThrows
    public static String deleteRequest(String service, String... params) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(AsaasApiConfig.BASE_URL() + service))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("access_token", AsaasApiConfig.getApiKey())
                .headers(params)
                .DELETE()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

}
