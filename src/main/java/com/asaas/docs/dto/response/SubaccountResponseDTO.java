package com.asaas.docs.dto.response;

import com.asaas.docs.enums.CompanyType;
import com.asaas.docs.enums.PersonType;
import com.asaas.docs.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubaccountResponseDTO {

    private String object;
    private String id;
    private String name;
    private String email;
    private String loginEmail;
    private String phone;
    private String mobilePhone;
    private String address;
    private String addressNumber;
    private String complement;
    private String province;
    private String postalCode;
    private String cpfCnpj;
    private String birthDate;
    private PersonType personType;
    private CompanyType companyType;
    private int city;
    private State state;
    private String country;
    private String tradingName;
    private String site;
    private String walletId;
    private AsaasAccountNumberResponseDTO accountNumber;
    private CommercialInfoExpirationResponseDTO commercialInfoExpiration;
    private String apiKey;

}
