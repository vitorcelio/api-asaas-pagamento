package com.asaas.docs.service.notifications;

import com.asaas.docs.dto.request.NotificationRequestDTO;
import com.asaas.docs.dto.request.NotificationsBatchRequestDTO;
import com.asaas.docs.dto.response.NotificationResponseDTO;
import com.asaas.docs.dto.response.NotificationsBatchResponseDTO;
import lombok.NonNull;

public interface NotificationsService {

    NotificationResponseDTO updateExistingNotification(@NonNull String id, @NonNull NotificationRequestDTO request);

    NotificationsBatchResponseDTO updateExistingNotificationsBatch(@NonNull NotificationsBatchRequestDTO request);

}
