package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PixPaymentResponseDTO {

    private String encodedImage;
    private String payload;
    private String expirationDate;

}
