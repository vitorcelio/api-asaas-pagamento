package com.asaas.docs.dto.request;

import com.asaas.docs.enums.CompanyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubaccountRequestDTO {

    private String name;
    private String email;
    private String loginEmail;
    private String cpfCnpj;
    private String birthDate;
    private CompanyType companyType;
    private String phone;
    private String mobilePhone;
    private String site;
    private BigDecimal incomeValue;
    private String address;
    private String addressNumber;
    private String complement;
    private String province;
    private String postalCode;
    private List<WebhookRequestDTO> webhooks;

}
