package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsaasAccountNumberResponseDTO {

    private String agency;
    private String account;
    private String accountDigit;

}
