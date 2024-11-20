package com.asaas.docs.dto.request;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.enums.EventWebhook;
import com.asaas.docs.enums.SendType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebhookRequestDTO {

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
