package com.asaas.docs.service.pix.impl;

import com.asaas.docs.client.BaseClient;
import com.asaas.docs.dto.request.PixTransactionRequestDTO;
import com.asaas.docs.dto.request.QrCodePixRequestDTO;
import com.asaas.docs.dto.response.PixTransactionListResponseDTO;
import com.asaas.docs.dto.response.PixTransactionResponseDTO;
import com.asaas.docs.dto.response.QrCodeDecodeResponseDTO;
import com.asaas.docs.enums.TransactionStatus;
import com.asaas.docs.enums.TransactionType;
import com.asaas.docs.exception.AsaasApiException;
import com.asaas.docs.service.pix.TransactionService;
import com.asaas.docs.util.AsaasUtil;
import com.google.gson.Gson;
import lombok.NonNull;

public class TransactionServiceImpl implements TransactionService {

    private Gson gson = new Gson();

    @Override
    public PixTransactionResponseDTO payQrCode(@NonNull PixTransactionRequestDTO request) {

        try {
            String response = BaseClient.postRequest(AsaasUtil.PAY_QRCODE, gson.toJson(request));
            return gson.fromJson(response, PixTransactionResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public QrCodeDecodeResponseDTO decodeQrCodeForPayment(@NonNull QrCodePixRequestDTO request) {

        try {
            String response = BaseClient.postRequest(AsaasUtil.DECODE_QRCODE_FOR_PAYMENT, gson.toJson(request));
            return gson.fromJson(response, QrCodeDecodeResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PixTransactionResponseDTO getPixTransaction(@NonNull String id) {

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.GET_TRANSACTION, id), null);
            return gson.fromJson(response, PixTransactionResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PixTransactionListResponseDTO transactionsList(Integer offset, Integer limit, TransactionStatus status, TransactionType type, String endToEndIdentifier) {

        var query = AsaasUtil.getParamsListTransactions(offset, limit, status, type, endToEndIdentifier);

        try {
            String response = BaseClient.getRequest(AsaasUtil.LIST_TRANSACTIONS, query);
            return gson.fromJson(response, PixTransactionListResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PixTransactionResponseDTO cancelScheduledTransaction(@NonNull String id) {

        try {
            String response = BaseClient.postRequest(String.format(AsaasUtil.CANCEL_SCHEDULED_TRANSACTION, id), null);
            return gson.fromJson(response, PixTransactionResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

}
