package com.asaas.docs.dto.request;

import com.asaas.docs.enums.BankAccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountRequestDTO {

    private BankRequestDTO bank;
    private String accountName;
    private String ownerName;
    private String ownerBirthDate;
    private String cpfCnpj;
    private String agency;
    private String account;
    private String accountDigit;
    private BankAccountType bankAccountType;
    private String ispb;

}
