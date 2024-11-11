package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QrCodeResponseDTO {

    private String id;
    private String encodedImage;
    private String payload;
    private boolean allowsMultiplePayments;
    private String expirationDate;
    private String externalReference;

}
