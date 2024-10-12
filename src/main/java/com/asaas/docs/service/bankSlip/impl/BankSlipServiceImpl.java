package com.asaas.docs.service.bankSlip.impl;

import com.asaas.docs.client.BaseClient;
import com.asaas.docs.dto.response.BankSlipRefundResponseDTO;
import com.asaas.docs.exception.AsaasApiException;
import com.asaas.docs.service.bankSlip.BankSlipService;
import com.asaas.docs.util.AsaasUtil;
import com.google.gson.Gson;
import lombok.NonNull;

public class BankSlipServiceImpl implements BankSlipService {

    private final Gson gson = new Gson();

    @Override
    public BankSlipRefundResponseDTO bankSlipRefund(@NonNull String id) {

        try {
            String response = BaseClient.postRequest(String.format(AsaasUtil.BANK_SLIP_REFUND, id), null);
            return gson.fromJson(response, BankSlipRefundResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }
}
