package com.pagamentos.asaas.dto.response;

import com.pagamentos.asaas.enums.ReasonChargeback;
import com.pagamentos.asaas.enums.StatusChargeback;
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
