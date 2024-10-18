package com.asaas.docs.service.notifications.impl;

import com.asaas.docs.client.BaseClient;
import com.asaas.docs.dto.request.NotificationRequestDTO;
import com.asaas.docs.dto.request.NotificationsBatchRequestDTO;
import com.asaas.docs.dto.response.NotificationResponseDTO;
import com.asaas.docs.dto.response.NotificationsBatchResponseDTO;
import com.asaas.docs.exception.AsaasApiException;
import com.asaas.docs.service.notifications.NotificationsService;
import com.asaas.docs.util.AsaasUtil;
import com.google.gson.Gson;
import lombok.NonNull;

public class NotificationsServiceImpl implements NotificationsService {

    private final Gson gson = new Gson();

    @Override
    public NotificationResponseDTO updateExistingNotification(@NonNull String id, @NonNull NotificationRequestDTO request) {

        try {
            String response = BaseClient.putRequest(String.format(AsaasUtil.UPDATE_EXISTING_NOTIFICATION, id), gson.toJson(request));
            return gson.fromJson(response, NotificationResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public NotificationsBatchResponseDTO updateExistingNotificationsBatch(@NonNull NotificationsBatchRequestDTO request) {

        try {
            String response = BaseClient.putRequest(AsaasUtil.UPDATE_EXISTING_NOTIFICATIONS_BATCH, gson.toJson(request));
            return gson.fromJson(response, NotificationsBatchResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }
}
