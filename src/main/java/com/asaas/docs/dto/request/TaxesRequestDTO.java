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
public class TaxesRequestDTO {

    private boolean retainIss;
    private BigDecimal cofins;
    private BigDecimal csll;
    private BigDecimal inss;
    private BigDecimal ir;
    private BigDecimal pis;
    private BigDecimal iss;

}
