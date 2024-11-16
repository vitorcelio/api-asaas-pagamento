package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillBankSlipResponseDTO {

    private String identificationField;
    private BigDecimal value;
    private String dueDate;
    private String companyName;
    private String bank;
    private String beneficiaryCpfCnpj;
    private String beneficiaryName;
    private boolean allowChangeValue;
    private BigDecimal minValue;
    private BigDecimal maxValue;
    private BigDecimal discountValue;
    private BigDecimal interestValue;
    private BigDecimal fineValue;
    private BigDecimal originalValue;
    private BigDecimal totalDiscountValue;
    private BigDecimal totalAdditionalValue;
    private boolean isOverdue;

}
