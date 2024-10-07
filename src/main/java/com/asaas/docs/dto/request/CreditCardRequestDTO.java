package com.asaas.docs.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditCardRequestDTO {

    private String holderName;
    private String number;
    private String expiryMonth;
    private String expiryYear;
    private String ccv;

}
