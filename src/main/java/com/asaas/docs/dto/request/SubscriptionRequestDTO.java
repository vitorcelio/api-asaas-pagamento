package com.asaas.docs.dto.request;

import com.asaas.docs.enums.BillingType;
import com.asaas.docs.enums.CycleType;
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
public class SubscriptionRequestDTO {

    private String customer;
    private BillingType billingType;
    private BigDecimal value;
    private String nextDueDate;
    private DiscountRequestDTO discount;
    private InterestRequestDTO interest;
    private FineRequestDTO fine;
    private CycleType cycle;
    private String description;
    private String endDate;
    private int maxPayments;
    private String externalReference;
    private List<SplitRequestDTO> split;
    private CallbackRequestDTO callback;
    private CreditCardRequestDTO creditCard;
    private CreditCardHolderInfoRequestDTO creditCardHolderInfo;
    private String creditCardToken;
    private String remoteIp;

}
