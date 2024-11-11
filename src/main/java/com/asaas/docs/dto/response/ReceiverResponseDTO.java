package com.asaas.docs.dto.response;

import com.asaas.docs.enums.AccountType;
import com.asaas.docs.enums.PersonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiverResponseDTO {

    private String ispb;
    private String ispbName;
    private String name;
    private String tradingName;
    private String cpfCnpj;
    private PersonType personType;
    private AccountType accountType;

}
