package com.asaas.docs.dto.response;

import com.asaas.docs.enums.AccountRegistrationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckAccountRegistrationStatusResponseDTO {

    private String id;
    private AccountRegistrationStatus commercialInfo;
    private AccountRegistrationStatus bankAccountInfo;
    private AccountRegistrationStatus documentation;
    private AccountRegistrationStatus general;

}
