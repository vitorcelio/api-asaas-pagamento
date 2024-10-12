package com.asaas.docs.service.creditCard.impl;

import com.asaas.docs.client.BaseClient;
import com.asaas.docs.dto.request.CreditCardTokenizationRequestDTO;
import com.asaas.docs.dto.response.CreditCardResponseDTO;
import com.asaas.docs.exception.AsaasApiException;
import com.asaas.docs.service.creditCard.CreditCardService;
import com.asaas.docs.util.AsaasUtil;
import com.google.gson.Gson;
import lombok.NonNull;

public class CreditCardServiceImpl implements CreditCardService {

    private final Gson gson = new Gson();

    @Override
    public CreditCardResponseDTO tokenizeCreditCard(@NonNull CreditCardTokenizationRequestDTO request) {

        try {
            String response = BaseClient.postRequest(AsaasUtil.TOKENIZE_CREDIT_CARD, gson.toJson(request));
            return gson.fromJson(response, CreditCardResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }
}
