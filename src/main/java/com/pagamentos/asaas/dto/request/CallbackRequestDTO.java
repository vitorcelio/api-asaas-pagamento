package com.pagamentos.asaas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CallbackRequestDTO {

    private String successUrl;
    private boolean autoRedirect;

}
