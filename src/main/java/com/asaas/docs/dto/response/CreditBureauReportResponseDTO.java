package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditBureauReportResponseDTO {

    private BigDecimal naturalPersonFeeValue;
    private BigDecimal legalPersonFeeValue;

}
