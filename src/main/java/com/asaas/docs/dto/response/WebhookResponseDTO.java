package com.asaas.docs.dto.response;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.enums.EventWebhook;
import com.asaas.docs.enums.SendType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebhookResponseDTO {

    private String id;
    private String name;
    private String url;
    private String email;
    private boolean enabled;
    private boolean interrupted;
    private int apiVersion = AsaasApiConfig.getVersion().getNumberVersion();
    private String authToken;
    private SendType sendType;
    private List<EventWebhook> events;

}
