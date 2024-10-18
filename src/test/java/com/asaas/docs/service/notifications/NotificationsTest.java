package com.asaas.docs.service.notifications;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.dto.request.NotificationRequestDTO;
import com.asaas.docs.dto.request.NotificationsBatchRequestDTO;
import com.asaas.docs.dto.response.NotificationResponseDTO;
import com.asaas.docs.dto.response.NotificationsBatchResponseDTO;
import com.asaas.docs.enums.ScheduleOffset;
import com.asaas.docs.service.notifications.impl.NotificationsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static com.asaas.docs.enums.ScheduleOffset.*;
import static org.junit.jupiter.api.Assertions.*;

public class NotificationsTest {

    @InjectMocks
    private NotificationsServiceImpl notificationsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        AsaasApiConfig.setApiKey(AsaasApiConfig.API_KEY_ASAAS);
    }

    @Test
    public void testUpdateExistingNotification_Success() {

        NotificationRequestDTO request = NotificationRequestDTO.builder()
                .id("not_0gtti3qr382lpuk1")
                .enabled(false)
                .build();

        NotificationResponseDTO response = notificationsService.updateExistingNotification("cus_000006287494", request);
        assertNotNull(response);
        assertEquals("not_0gtti3qr382lpuk1", response.getId());
        assertFalse(response.isEnabled());
    }

    @Test
    public void testUpdateExistingNotificationsBatch_Success() {

        NotificationsBatchRequestDTO request = NotificationsBatchRequestDTO.builder()
                .customer("cus_000006287494")
                .notifications(Arrays.asList(
                    // Notificacão 1
                    NotificationRequestDTO.builder()
                        .id("not_0gtti3qr382lpuk1")
                        .enabled(true)
                        .build(),
                    // Notificação 2
                    NotificationRequestDTO.builder()
                        .id("not_upf3i2mxzvefogf0")
                        .smsEnabledForProvider(true)
                        .build(),
                    // Notificação 3
                    NotificationRequestDTO.builder()
                        .id("not_5r5owemixrxnqhcs")
                        .emailEnabledForProvider(true)
                        .scheduleOffset(TEN_DAYS.getValue())
                        .build()
                ))
                .build();

        NotificationsBatchResponseDTO response = notificationsService.updateExistingNotificationsBatch(request);
        assertNotNull(response);
        assertNotNull(response.getNotifications());

    }

}
