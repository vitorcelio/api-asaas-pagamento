package com.asaas.docs.dto.response;

import com.asaas.docs.enums.EventType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationResponseDTO {

    private String object;
    private String id;
    private String customer;
    private boolean enabled;
    private boolean emailEnabledForProvider;
    private boolean smsEnabledForProvider;
    private boolean emailEnabledForCustomer;
    private boolean smsEnabledForCustomer;
    private boolean phoneCallEnabledForCustomer;
    private boolean whatsappEnabledForCustomer;
    private EventType event;
    private int scheduleOffset;
    private boolean deleted;

}
