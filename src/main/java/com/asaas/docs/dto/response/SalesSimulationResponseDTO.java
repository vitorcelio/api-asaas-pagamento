package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesSimulationResponseDTO {

    private BigDecimal value;
    private CreditCardFeeResponseDTO creditCard;
    private BankSlipFeeResponseDTO bankSlip;
    private PixFeeResponseDTO pix;

}
