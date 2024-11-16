package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalAccountRecurrenceResponseDTO {

    private String name;
    private String financialInstitutionName;
    private String cpfCnpj;
    private String pixKey;

}
