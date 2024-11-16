package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsaasAccountResponseDTO {

    private String name;
    private String cpfCnpj;
    private String agency;
    private String account;
    private String accountDigit;

}
