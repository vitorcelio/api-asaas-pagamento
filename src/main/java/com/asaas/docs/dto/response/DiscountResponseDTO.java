package com.asaas.docs.dto.response;

import com.asaas.docs.enums.CostType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountResponseDTO {

    private BigDecimal value;
    private int dueDateLimitDays;
    private CostType type;

}
