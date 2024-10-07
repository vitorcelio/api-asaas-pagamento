package com.asaas.docs.dto.request;

import com.asaas.docs.enums.BillingType;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequestDTO {

    @NonNull
    private String customer;
    @NonNull
    private BillingType billingType;
    @NonNull
    private BigDecimal value;
    @NonNull
    private Date dueDate;
    private String description;
    private int daysAfterDueDateToRegistrationCancellation;
    private String externalReference;
    private int installmentCount;
    private BigDecimal totalValue;
    private BigDecimal installmentValue;
    private DiscountRequestDTO discount;
    private InterestRequestDTO interest;
    private FineRequestDTO fine;
    private boolean postalService;
    private List<SplitRequestDTO> split;
    private CallbackRequestDTO callback;
    private CreditCardRequestDTO creditCard;
    private CreditCardHolderInfoRequestDTO creditCardHolderInfo;
    private String creditCardToken;
    private boolean authorizeOnly;
    private String remoteIp;

}
