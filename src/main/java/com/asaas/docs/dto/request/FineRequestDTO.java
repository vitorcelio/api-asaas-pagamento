package com.asaas.docs.dto.request;

import com.asaas.docs.enums.CostType;
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
