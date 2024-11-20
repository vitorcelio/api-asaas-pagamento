package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentFeeResponseDTO {

    private BankSlipPaymentFeeResponseDTO bankSlip;
    private CreditCardPaymentFeeResponseDTO creditCard;
    private DebitCardPaymentFeeResponseDTO debitCard;
    private PixPaymentFeeResponseDTO pix;

}
