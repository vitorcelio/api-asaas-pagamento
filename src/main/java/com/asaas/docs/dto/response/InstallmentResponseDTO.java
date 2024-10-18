package com.asaas.docs.dto.response;

import com.asaas.docs.enums.BillingType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstallmentResponseDTO {

    private String object;
    private String id;
    private BigDecimal value;
    private BigDecimal netValue;
    private BigDecimal paymentValue;
    private int installmentCount;
    private BillingType billingType;
    private String paymentDate;
    private String description;
    private int expirationDay;
    private String dateCreated;
    private String customer;
    private String paymentLink;
    private String transactionReceiptUrl;
    private ChargebackResponseDTO chargeback;
    private CreditCardResponseDTO creditCard;
    private boolean deleted;

}
