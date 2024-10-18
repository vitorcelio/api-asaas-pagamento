package com.asaas.docs.dto.request;

import com.asaas.docs.enums.BillingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstallmentRequestDTO {

    private int installmentCount;
    private String customer;
    private BigDecimal value;
    private BigDecimal totalValue;
    private BillingType billingType;
    private String dueDate;
    private String description;
    private boolean postalService;
    private int daysAfterDueDateToRegistrationCancellation;
    private String paymentExternalReference;
    private DiscountRequestDTO discount;
    private InterestRequestDTO interest;
    private FineRequestDTO fine;
    private List<SplitRequestDTO> splits;
    private CreditCardRequestDTO creditCard;
    private CreditCardHolderInfoRequestDTO creditCardHolder;
    private String creditCardToken;
    private boolean authorizeOnly;
    private String remoteIp;

}
