package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PixTransferFeeResponseDTO {

    private BigDecimal feeValue;
    private BigDecimal discountValue;
    private String expirationValue;
    private boolean consideredInMonthlyTransfersWithoutFee;

}
