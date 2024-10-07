package com.asaas.docs.dto.response;

import com.asaas.docs.enums.CreditCardBrand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardResponseDTO {

    private String creditCardNumber;
    private CreditCardBrand creditCardBrand;
    private String creditCardToken;

}
