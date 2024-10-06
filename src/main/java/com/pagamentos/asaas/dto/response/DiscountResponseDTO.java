package com.pagamentos.asaas.dto.response;

import com.pagamentos.asaas.enums.CostType;
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
