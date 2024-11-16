package com.asaas.docs.service.transfer.impl;

import com.asaas.docs.client.BaseClient;
import com.asaas.docs.dto.request.TransferAsaasAccountRequestDTO;
import com.asaas.docs.dto.request.TransferRequestDTO;
import com.asaas.docs.dto.response.TransferListResponseDTO;
import com.asaas.docs.dto.response.TransferResponseDTO;
import com.asaas.docs.enums.AccountTransferType;
import com.asaas.docs.exception.AsaasApiException;
import com.asaas.docs.service.transfer.TransferService;
import com.asaas.docs.util.AsaasUtil;
import com.google.gson.Gson;
import lombok.NonNull;

public class TransferServiceImpl implements TransferService {

    private Gson gson = new Gson();

    @Override
    public TransferResponseDTO transferAnotherInstitutionOrPix(@NonNull TransferRequestDTO request) {

        try {
            String response = BaseClient.postRequest(AsaasUtil.TRANSFER_ANOTHER_INSTITUTION_OR_PIX, gson.toJson(request));
            return gson.fromJson(response, TransferResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public TransferListResponseDTO transferList(String dateCreatedGe, String dateCreatedLe, String transferDateGe,
                                                String transferDateLe, AccountTransferType type) {

        var query = AsaasUtil.getParamsListTransfers(dateCreatedGe, dateCreatedLe, transferDateGe, transferDateLe, type);

        try {
            String response = BaseClient.getRequest(AsaasUtil.LIST_TRANSFERS, query);
            return gson.fromJson(response, TransferListResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public TransferResponseDTO transferAsaasAccount(@NonNull TransferAsaasAccountRequestDTO request) {

        try {
            String response = BaseClient.postRequest(AsaasUtil.TRANSFER_ASAAS_ACCOUNT, gson.toJson(request));
            return gson.fromJson(response, TransferResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public TransferResponseDTO getTransfer(@NonNull String id) {

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.GET_TRANSFER, id), null);
            return gson.fromJson(response, TransferResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public TransferResponseDTO cancelTransfer(@NonNull String id) {

        try {
            String response = BaseClient.deleteRequest(String.format(AsaasUtil.CANCEL_TRANSFER, id));
            return gson.fromJson(response, TransferResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }
}
