package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QrCodePixTransactionResponseDTO {

    private PayerResponseDTO payer;
    private String conciliationIdentifier;
    private BigDecimal originalValue;
    private String dueDate;
    private BigDecimal interest;
    private BigDecimal fine;
    private BigDecimal discount;
    private String expirationDate;

}
