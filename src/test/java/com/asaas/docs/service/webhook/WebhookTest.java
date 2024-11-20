package com.asaas.docs.service.webhook;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.dto.request.WebhookRequestDTO;
import com.asaas.docs.dto.request.WebhookUpdateRequestDTO;
import com.asaas.docs.dto.response.DeleteResponseDTO;
import com.asaas.docs.dto.response.WebhookListResponseDTO;
import com.asaas.docs.dto.response.WebhookResponseDTO;
import com.asaas.docs.enums.EventWebhook;
import com.asaas.docs.enums.SendType;
import com.asaas.docs.service.webhook.impl.WebhookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static com.asaas.docs.configuration.AsaasApiConfig.API_KEY_ASAAS;
import static org.junit.jupiter.api.Assertions.*;

public class WebhookTest {

    @InjectMocks
    private WebhookServiceImpl webhookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        AsaasApiConfig.setApiKey(API_KEY_ASAAS);
    }

    @Test
    public void testCreateWebhook_Success() {

        WebhookRequestDTO request = WebhookRequestDTO.builder()
                .name("Testando Webhook")
                .url("https://vitorcelio.vercel.app")
                .email("celiovitor62@gmail.com")
                .enabled(true)
                .interrupted(false)
                .sendType(SendType.SEQUENTIALLY)
                .events(Arrays.asList(EventWebhook.PAYMENT_CREATED, EventWebhook.PAYMENT_UPDATED))
                .build();

        WebhookResponseDTO response = webhookService.createWebhook(request);
        assertEquals(WebhookResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals(request.getSendType(), response.getSendType());
        assertEquals(request.getUrl(), response.getUrl());
        assertEquals(request.getEmail(), response.getEmail());

    }

    @Test
    public void testWebhooksList_Success() {
        WebhookListResponseDTO response = webhookService.webhooksList(null, null);

        assertEquals(WebhookListResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertNotNull(response.getData());

    }

    @Test
    public void testGetWebhook_Success() {
        WebhookResponseDTO response = webhookService.getWebhook("7fce358d-6da8-4bfc-ada3-8b05e02e0812");

        assertEquals(WebhookResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals("7fce358d-6da8-4bfc-ada3-8b05e02e0812", response.getId());
        assertEquals("celiovitor62@gmail.com", response.getEmail());

    }

    @Test
    public void testUpdateWebhook_Success() {

        WebhookUpdateRequestDTO request = WebhookUpdateRequestDTO.builder()
                .name("Testando Webhook editado")
                .events(Arrays.asList(EventWebhook.PAYMENT_CREATED, EventWebhook.PAYMENT_UPDATED,
                        EventWebhook.PAYMENT_DELETED))
                .build();

        WebhookResponseDTO response = webhookService.updateWebhook("7fce358d-6da8-4bfc-ada3-8b05e02e0812", request);
        assertEquals(WebhookResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals(request.getName(), response.getName());
    }

    @Test
    public void testDeleteWebhook_Success() {
        DeleteResponseDTO response = webhookService.deleteWebhook("7fce358d-6da8-4bfc-ada3-8b05e02e0812");

        assertEquals(DeleteResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertTrue(response.isDeleted());
    }

}
