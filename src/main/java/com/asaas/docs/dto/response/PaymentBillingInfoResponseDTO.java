package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentBillingInfoResponseDTO {

    private PixPaymentResponseDTO pix;
    private CreditCardResponseDTO creditCard;
    private BankSlipResponseDTO bankSlip;

}
