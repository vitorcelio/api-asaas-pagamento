package com.asaas.docs.dto.response;

import com.asaas.docs.enums.ReasonChargeback;
import com.asaas.docs.enums.StatusChargeback;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChargebackResponseDTO {

    private StatusChargeback status;
    private ReasonChargeback reason;

}
