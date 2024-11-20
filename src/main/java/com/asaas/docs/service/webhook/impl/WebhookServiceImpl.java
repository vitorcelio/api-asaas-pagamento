package com.asaas.docs.service.webhook.impl;

import com.asaas.docs.client.BaseClient;
import com.asaas.docs.dto.request.WebhookRequestDTO;
import com.asaas.docs.dto.request.WebhookUpdateRequestDTO;
import com.asaas.docs.dto.response.DeleteResponseDTO;
import com.asaas.docs.dto.response.WebhookListResponseDTO;
import com.asaas.docs.dto.response.WebhookResponseDTO;
import com.asaas.docs.exception.AsaasApiException;
import com.asaas.docs.service.webhook.WebhookService;
import com.asaas.docs.util.AsaasUtil;
import com.google.gson.Gson;
import lombok.NonNull;

public class WebhookServiceImpl implements WebhookService {

    private Gson gson = new Gson();

    @Override
    public WebhookResponseDTO createWebhook(@NonNull WebhookRequestDTO request) {

        try {
            String response = BaseClient.postRequest(AsaasUtil.CREATE_WEBHOOK, gson.toJson(request));
            return gson.fromJson(response, WebhookResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public WebhookListResponseDTO webhooksList(Integer offset, Integer limit) {

        var query = AsaasUtil.getParamsListBase(offset, limit);

        try {
            String response = BaseClient.getRequest(AsaasUtil.LIST_WEBHOOK, query);
            return gson.fromJson(response, WebhookListResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public WebhookResponseDTO getWebhook(@NonNull String id) {

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.GET_WEBHOOK, id), null);
            return gson.fromJson(response, WebhookResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public WebhookResponseDTO updateWebhook(@NonNull String id, @NonNull WebhookUpdateRequestDTO request) {

        try {
            String response = BaseClient.putRequest(String.format(AsaasUtil.UPDATE_WEBHOOK, id), gson.toJson(request));
            return gson.fromJson(response, WebhookResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public DeleteResponseDTO deleteWebhook(@NonNull String id) {

        try {
            String response = BaseClient.deleteRequest(String.format(AsaasUtil.DELETE_WEBHOOK, id));
            return gson.fromJson(response, DeleteResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }
}
