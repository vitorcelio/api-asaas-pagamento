package com.pagamentos.asaas.dto.request;

import com.pagamentos.asaas.enums.BillingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CobrancaRequestDTO {

    private String customer;
    private BillingType billingType;
    private BigDecimal value;
    private Date dueDate;
    private String description;
    private int daysAfterDueDateToRegistrationCancellation;
    private String externalReference;
    private BigDecimal installmentValue;
    private DiscountRequestDTO discount;
    private InterestRequestDTO interest;
    private FineRequestDTO fine;
    private boolean postalService;
    private List<SplitRequestDTO> split;
    private CallbackRequestDTO callback;

}
