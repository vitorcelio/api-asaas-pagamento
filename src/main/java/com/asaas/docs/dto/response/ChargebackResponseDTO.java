package com.asaas.docs.dto.response;

import com.asaas.docs.enums.ReasonChargeback;
import com.asaas.docs.enums.ChargebackStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChargebackResponseDTO {

    private ChargebackStatus status;
    private ReasonChargeback reason;

}
