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
public class PaymentUpdateRequestDTO {

    private BillingType billingType;
    private BigDecimal value;
    private String dueDate;
    private String description;
    private int daysAfterDueDateToRegistrationCancellation;
    private String externalReference;
    private DiscountRequestDTO discount;
    private InterestRequestDTO interest;
    private FineRequestDTO fine;
    private boolean postalService;
    private List<SplitRequestDTO> split;
    private CallbackRequestDTO callback;

}
