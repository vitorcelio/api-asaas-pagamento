package com.asaas.docs.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CheckoutCustomizationRequestDTO {

    private String logoBackgroundColor;
    private String infoBackgroundColor;
    private String fontColor;
    private boolean enabled;

}
