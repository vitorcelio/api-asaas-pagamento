package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationFeeResponseDTO {

    private BigDecimal phoneCallFeeValue;
    private BigDecimal whatsAppFeeValue;
    private BigDecimal messagingFeeValue;

}
