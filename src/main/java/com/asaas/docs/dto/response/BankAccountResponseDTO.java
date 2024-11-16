package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountResponseDTO {

    private BankResponseDTO bank;
    private String accountName;
    private String ownerName;
    private String cpfCnpj;
    private String agency;
    private String agencyDigit;
    private String account;
    private String accountDigit;
    private String pixAddressKey;

}
