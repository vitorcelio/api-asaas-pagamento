package com.asaas.docs.dto.response;

import com.asaas.docs.enums.AccountStatus;
import com.asaas.docs.enums.CompanyType;
import com.asaas.docs.enums.PersonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessDataResponseDTO {

    private AccountStatus status;
    private PersonType personType;
    private String cpfCnpj;
    private String name;
    private String birthDate;
    private String companyName;
    private CompanyType companyType;
    private BigDecimal incomeValue;
    private String email;
    private String phone;
    private String mobilePhone;
    private String postalCode;
    private String address;
    private String addressNumber;
    private String complement;
    private String province;
    private CityResponseDTO city;
    private String denialReason;
    private String tradingName;
    private String site;
    private CommercialInfoExpirationResponseDTO commercialInfoExpiration;

}
