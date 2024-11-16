package com.asaas.docs.dto.response;

import com.asaas.docs.enums.ExtractTransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtractTransactionResponseDTO {

    private String object;
    private String id;
    private BigDecimal value;
    private BigDecimal balance;
    private ExtractTransactionType type;
    private String date;
    private String description;
    private String paymentId;
    private String splitId;
    private String transferId;
    private String anticipationId;
    private String billId;
    private String invoiceId;
    private String paymentDunningId;
    private String creditBureauReportId;

}
