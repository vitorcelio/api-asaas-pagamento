package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentViewingInfoResponseDTO {

    private LocalDateTime invoiceViewedDate;
    private LocalDateTime boletoViewedDate;

}
