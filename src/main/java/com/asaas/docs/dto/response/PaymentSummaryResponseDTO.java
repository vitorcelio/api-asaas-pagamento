package com.asaas.docs.dto.response;

import com.asaas.docs.enums.BillingType;
import com.asaas.docs.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentSummaryResponseDTO {

    private String object;
    private String id;
    private String dateCreated;
    private String customerId;
    private String subscriptionId;
    private String installmentId;
    private String paymentLinkId;
    private BigDecimal value;
    private BigDecimal netValue;
    private BigDecimal originalValue;
    private BigDecimal interestValue;
    private String description;
    private BillingType billingType;
    private boolean canBePaidAfterDueDate;
    private String confirmedDate;
    private String pixTransactionId;
    private PaymentStatus status;
    private String dueDate;
    private String originalDueDate;
    private String paymentDate;
    private String customerPaymentDate;
    private int installmentNumber;
    private String externalReference;
    private boolean deleted;
    private boolean anticipated;
    private boolean anticipable;
    private String creditDate;
    private String transactionReceiptUrl;
    private String duplicatedPaymentId;
    private DiscountResponseDTO discount;
    private FineResponseDTO fine;
    private boolean postalService;
    private CreditCardResponseDTO creditCard;

}
