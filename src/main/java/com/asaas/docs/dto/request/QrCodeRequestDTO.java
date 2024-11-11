package com.asaas.docs.dto.request;

import com.asaas.docs.enums.FormatQrCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QrCodeRequestDTO {

    private String addressKey;
    private String description;
    private BigDecimal value;
    private FormatQrCode format;
    private String expirationDate;
    private int expirationSeconds;
    private boolean allowsMultiplePayments;
    private String externalReference;

}
