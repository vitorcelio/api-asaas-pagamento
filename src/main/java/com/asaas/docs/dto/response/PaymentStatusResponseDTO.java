package com.asaas.docs.dto.response;

import com.asaas.docs.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentStatusResponseDTO {

    private PaymentStatus status;

}
