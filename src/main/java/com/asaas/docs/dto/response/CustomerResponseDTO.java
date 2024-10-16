package com.asaas.docs.dto.response;

import com.asaas.docs.enums.PersonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO {

    private String object;
    private String id;
    private String dateCreated;
    private String name;
    private String email;
    private String phone;
    private String mobilePhone;
    private String address;
    private String addressNumber;
    private String complement;
    private String province;
    private String city;
    private String cityName;
    private String state;
    private String country;
    private String postalCode;
    private String cpfCnpj;
    private PersonType personType;
    private boolean deleted;
    private String additionsEmails;
    private String externalReference;
    private boolean notificationDisabled;
    private String observations;

}
