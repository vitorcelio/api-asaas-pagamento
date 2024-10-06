package com.pagamentos.asaas.dto.request;

import com.pagamentos.asaas.enums.CostType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiscountRequestDTO {

    private BigDecimal value;
    private int dueDateLimitDays;
    private CostType type;

}
