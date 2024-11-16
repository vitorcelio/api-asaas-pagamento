package com.asaas.docs.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillRequestDTO {

    private String identificationField;
    private String scheduleDate;
    private String description;
    private BigDecimal discount;
    private BigDecimal interest;
    private BigDecimal fine;
    private String dueDate;
    private BigDecimal value;
    private String externalReference;

}
