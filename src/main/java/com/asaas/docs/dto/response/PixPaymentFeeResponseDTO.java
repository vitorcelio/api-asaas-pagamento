package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PixPaymentFeeResponseDTO {

    private BigDecimal fixedFeeValue;
    private BigDecimal fixedFeeValueWithDiscount;
    private BigDecimal percentageFee;
    private BigDecimal minimumFeeValue;
    private BigDecimal maximumFeeValue;
    private String discountExpiration;
    private int monthlyCreditsWithoutFee;
    private int creditsReceivedOfCurrentMonth;

}
