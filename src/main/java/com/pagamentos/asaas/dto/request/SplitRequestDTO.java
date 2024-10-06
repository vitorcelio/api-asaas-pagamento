package com.pagamentos.asaas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SplitRequestDTO {

    private String walletId;
    private BigDecimal fixedValue;
    private BigDecimal percentualValue;
    private BigDecimal totalFixedValue;
    private String externalReference;
    private String description;

}
