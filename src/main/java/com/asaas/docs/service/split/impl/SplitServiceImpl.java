package com.asaas.docs.service.split.impl;

import com.asaas.docs.client.BaseClient;
import com.asaas.docs.dto.response.SplitListResponseDTO;
import com.asaas.docs.dto.response.SplitResponseDTO;
import com.asaas.docs.enums.StatusSplit;
import com.asaas.docs.exception.AsaasApiException;
import com.asaas.docs.service.split.SplitService;
import com.asaas.docs.util.AsaasUtil;
import com.google.gson.Gson;
import lombok.NonNull;

public class SplitServiceImpl implements SplitService {

    private final Gson gson = new Gson();

    @Override
    public SplitResponseDTO getSplitPaid(@NonNull String splitId) {

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.GET_SPLIT_PAID, splitId), null);
            return gson.fromJson(response, SplitResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public SplitListResponseDTO splitsPaidList(Integer offset, Integer limit, String paymentId, StatusSplit status,
                                               String paymentConfirmedDateGe, String paymentConfirmedDateLe,
                                               String creditDateGe, String creditDateLe) {

        var query = AsaasUtil.getParamsListSplit(offset, limit, paymentId, status, paymentConfirmedDateGe,
                paymentConfirmedDateLe, creditDateGe, creditDateLe);

        try {
            String response = BaseClient.getRequest(AsaasUtil.LIST_SPLITS_PAID, query);
            return gson.fromJson(response, SplitListResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public SplitResponseDTO getSplitReceived(@NonNull String splitId) {

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.GET_SPLIT_RECEIVED, splitId), null);
            return gson.fromJson(response, SplitResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public SplitListResponseDTO splitsReceivedList(Integer offset, Integer limit, String paymentId,
                                                   StatusSplit status, String paymentConfirmedDateGe,
                                                   String paymentConfirmedDateLe, String creditDateGe,
                                                   String creditDateLe) {

        var query = AsaasUtil.getParamsListSplit(offset, limit, paymentId, status, paymentConfirmedDateGe,
                paymentConfirmedDateLe, creditDateGe, creditDateLe);

        try {
            String response = BaseClient.getRequest(AsaasUtil.LIST_SPLITS_RECEIVED, query);
            return gson.fromJson(response, SplitListResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

}
