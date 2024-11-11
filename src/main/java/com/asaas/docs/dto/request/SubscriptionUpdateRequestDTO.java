package com.asaas.docs.dto.request;

import com.asaas.docs.enums.BillingType;
import com.asaas.docs.enums.CycleType;
import com.asaas.docs.enums.SubscriptionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubscriptionUpdateRequestDTO {

    private BillingType billingType;
    private SubscriptionStatus status;
    private String nextDueDate;
    private DiscountRequestDTO discount;
    private InterestRequestDTO interest;
    private FineRequestDTO fine;
    private CycleType cycle;
    private String description;
    private String endDate;
    private boolean updatePendingPayments;
    private String externalReference;
    private List<SplitRequestDTO> split;
    private CallbackRequestDTO callback;
    private CreditCardRequestDTO creditCard;
    private CreditCardHolderInfoRequestDTO creditCardHolderInfo;
    private String creditCardToken;

}
