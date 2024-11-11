package com.asaas.docs.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PixTransactionRequestDTO {

    private QrCodePixRequestDTO qrCode;
    private BigDecimal value;
    private String description;
    private String scheduleDate;

}
