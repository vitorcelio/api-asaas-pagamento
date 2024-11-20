package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnticipationFeeResponseDTO {

    private CreditCardAnticipationFeeResponseDTO creditCard;
    private BankSlipAnticipationFeeResponseDTO bankSlip;

}
