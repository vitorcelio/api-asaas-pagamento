package com.asaas.docs.service.webhook;

import com.asaas.docs.dto.request.WebhookRequestDTO;
import com.asaas.docs.dto.request.WebhookUpdateRequestDTO;
import com.asaas.docs.dto.response.DeleteResponseDTO;
import com.asaas.docs.dto.response.WebhookListResponseDTO;
import com.asaas.docs.dto.response.WebhookResponseDTO;
import lombok.NonNull;

public interface WebhookService {

    WebhookResponseDTO createWebhook(@NonNull WebhookRequestDTO request);

    WebhookListResponseDTO webhooksList(Integer offset, Integer limit);

    WebhookResponseDTO getWebhook(@NonNull String id);

    WebhookResponseDTO updateWebhook(@NonNull String id, @NonNull WebhookUpdateRequestDTO request);

    DeleteResponseDTO deleteWebhook(@NonNull String id);

}
