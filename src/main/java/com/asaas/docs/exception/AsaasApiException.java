package com.asaas.docs.exception;

import com.asaas.docs.util.AsaasUtil;

import java.util.List;

public class AsaasApiException extends RuntimeException {

    private AsaasErrorResponse errorResponse;

    public AsaasApiException() {
        super();
    }

    public AsaasApiException(String message) {
        super(message);
    }

    public AsaasApiException(Throwable cause) {
        super(cause);
    }

    public AsaasApiException(AsaasErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

    @Override
    public String getMessage() {

        if (errorResponse != null && !AsaasUtil.isEmpty(errorResponse.getErrors())) {
            List<String> erros = errorResponse.getErrors().stream().map(errorDTO -> String.format("[%s] - %s",
                    errorDTO.getCode(), errorDTO.getDescription())).toList();
            StringBuilder message = new StringBuilder();
            erros.forEach(e -> {
                message.append(e);

                if (erros.indexOf(e) > (erros.size() - 1)) {
                    message.append(", ");
                }
            });

            return message.toString();
        }

        return super.getMessage();
    }
}
