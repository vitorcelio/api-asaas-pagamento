package com.asaas.docs.dto.response;

import com.asaas.docs.enums.AddressPixKeyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalAccountResponseDTO {

    private String ispb;
    private String ispbName;
    private String name;
    private String cpfCnpj;
    private String addressKey;
    private AddressPixKeyType addressKeyType;

}
