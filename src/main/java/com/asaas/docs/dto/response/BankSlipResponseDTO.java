package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankSlipResponseDTO {

    private String identificationField;
    private String nossoNumero;
    private String barCode;
    private String bankSlipUrl;
    private int daysAfterDueDateToRegistrationCancellation;

}
