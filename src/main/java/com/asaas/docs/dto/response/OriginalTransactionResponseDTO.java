package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OriginalTransactionResponseDTO {

    private String id;
    private String endToEndIdentifier;
    private BigDecimal value;
    private String effectiveDate;

}
