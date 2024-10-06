package com.pagamentos.asaas.dto.request;

import com.pagamentos.asaas.enums.CostType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FineRequestDTO {

    private BigDecimal value;
    private CostType type;

}
