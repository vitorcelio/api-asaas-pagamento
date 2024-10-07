package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PixFeeResponseDTO {

    private BigDecimal netValue;
    private BigDecimal feePercentage;
    private BigDecimal feeValue;
    private InstallmentResponseDTO installment;

}
