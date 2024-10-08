package com.asaas.docs.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsaasErrorResponse {

    private List<ErrorDTO> errors;

    @Data
    static class ErrorDTO {
        private String code;
        private String description;
    }
}
