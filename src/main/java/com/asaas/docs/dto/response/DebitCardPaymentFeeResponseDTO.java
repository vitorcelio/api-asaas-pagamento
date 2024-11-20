package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DebitCardPaymentFeeResponseDTO {

    private BigDecimal operationValue;
    private BigDecimal defaultPercentage;
    private int daysToReceive;

}
