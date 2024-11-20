package com.asaas.docs.dto.request;

import com.asaas.docs.enums.CompanyType;
import com.asaas.docs.enums.PersonType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusinessDataRequestDTO {

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
    private String site;
    private String postalCode;
    private String address;
    private String addressNumber;
    private String complement;
    private String province;

}
