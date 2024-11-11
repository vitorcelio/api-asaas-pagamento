package com.asaas.docs.service.pix.impl;

import com.asaas.docs.client.BaseClient;
import com.asaas.docs.dto.request.PixRequestDTO;
import com.asaas.docs.dto.request.QrCodeRequestDTO;
import com.asaas.docs.dto.response.DeleteResponseDTO;
import com.asaas.docs.dto.response.PixListResponseDTO;
import com.asaas.docs.dto.response.PixResponseDTO;
import com.asaas.docs.dto.response.QrCodeResponseDTO;
import com.asaas.docs.enums.PixKeyStatus;
import com.asaas.docs.exception.AsaasApiException;
import com.asaas.docs.service.pix.PixService;
import com.asaas.docs.util.AsaasUtil;
import com.google.gson.Gson;
import lombok.NonNull;

public class PixServiceImpl implements PixService {

    private final Gson gson = new Gson();

    @Override
    public PixResponseDTO createKey(@NonNull PixRequestDTO request) {

        try {
            String response = BaseClient.postRequest(AsaasUtil.CREATE_KEY, gson.toJson(request));
            return gson.fromJson(response, PixResponseDTO.class);
        } catch (AsaasApiException e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PixListResponseDTO keysList(Integer offset, Integer limit, PixKeyStatus status, String statusList) {

        var query = AsaasUtil.getParamsListKeys(offset, limit, status, statusList);

        try {
            String response = BaseClient.getRequest(AsaasUtil.LIST_KEYS, query);
            return gson.fromJson(response, PixListResponseDTO.class);
        } catch (AsaasApiException e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PixResponseDTO getKey(@NonNull String id) {

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.GET_KEY, id), null);
            return gson.fromJson(response, PixResponseDTO.class);
        } catch (AsaasApiException e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PixResponseDTO deleteKey(@NonNull String id) {

        try {
            String response = BaseClient.deleteRequest(String.format(AsaasUtil.DELETE_KEY, id));
            return gson.fromJson(response, PixResponseDTO.class);
        } catch (AsaasApiException e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public QrCodeResponseDTO createStaticQrCode(QrCodeRequestDTO request) {

        try {
            String response = BaseClient.postRequest(AsaasUtil.CREATE_STATIC_QRCODE, gson.toJson(request));
            return gson.fromJson(response, QrCodeResponseDTO.class);
        } catch (AsaasApiException e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public DeleteResponseDTO deleteStaticQrCode(@NonNull String id) {

        try {
            String response = BaseClient.deleteRequest(String.format(AsaasUtil.DELETE_STATIC_QRCODE, id));
            return gson.fromJson(response, DeleteResponseDTO.class);
        } catch (AsaasApiException e) {
            throw new AsaasApiException(e);
        }

    }
}
