package com.asaas.docs.dto.response;

import com.asaas.docs.enums.CheckoutCustomizationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutCustomizationResponseDTO {

    private String object;
    private String logoBackgroundColor;
    private String infoBackgroundColor;
    private String fontColor;
    private boolean enabled;
    private String logoUrl;
    private String observations;
    private CheckoutCustomizationStatus status;

}
