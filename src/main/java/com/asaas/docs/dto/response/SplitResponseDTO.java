package com.asaas.docs.dto.response;

import com.asaas.docs.enums.CancellationReason;
import com.asaas.docs.enums.SplitStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SplitResponseDTO {

    private String id;
    private String walletId;
    private BigDecimal fixedValue;
    private BigDecimal percentualValue;
    private BigDecimal totalValue;
    private CancellationReason cancellationReason;
    private SplitStatus status;
    private String externalReference;
    private String description;

}
