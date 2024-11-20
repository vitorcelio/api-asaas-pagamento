package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankSlipPaymentFeeResponseDTO {

    private BigDecimal defaultValue;
    private BigDecimal discountValue;
    private String expirationDate;
    private int daysToReceive;

}
