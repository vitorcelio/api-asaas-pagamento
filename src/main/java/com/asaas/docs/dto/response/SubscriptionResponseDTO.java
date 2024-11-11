package com.asaas.docs.dto.response;

import com.asaas.docs.enums.BillingType;
import com.asaas.docs.enums.CycleType;
import com.asaas.docs.enums.SubscriptionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionResponseDTO {

    private String object;
    private String id;
    private String dateCreated;
    private String customer;
    private String paymentLink;
    private BillingType billingType;
    private CycleType cycle;
    private BigDecimal value;
    private String nextDueDate;
    private String endDate;
    private String description;
    private SubscriptionStatus status;
    private DiscountResponseDTO discount;
    private FineResponseDTO fine;
    private InterestResponseDTO interest;
    private boolean deleted;
    private int maxPayments;
    private String externalReference;
    private List<SplitResponseDTO> splits;

}
