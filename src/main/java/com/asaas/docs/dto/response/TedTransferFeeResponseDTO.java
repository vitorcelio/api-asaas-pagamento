package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TedTransferFeeResponseDTO {

    private BigDecimal feeValue;
    private boolean consideredInMonthlyWithoutFee;

}
