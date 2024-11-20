package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardPaymentFeeResponseDTO {

    private BigDecimal operationValue;
    private BigDecimal oneInstallmentPercentage;
    private BigDecimal upToSixInstallmentPercentage;
    private BigDecimal upToTwelveInstallmentPercentage;
    private BigDecimal discountOneInstallmentPercentage;
    private BigDecimal discountUpToSixInstallmentPercentage;
    private BigDecimal discountUpToTwelveInstallmentPercentage;
    private String discountExpiration;
    private int daysToReceive;

}
