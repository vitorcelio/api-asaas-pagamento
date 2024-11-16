package com.asaas.docs.service.installments.impl;

import com.asaas.docs.client.BaseClient;
import com.asaas.docs.dto.request.InstallmentRequestDTO;
import com.asaas.docs.dto.request.InstallmentSplitsRequestDTO;
import com.asaas.docs.dto.response.DeleteResponseDTO;
import com.asaas.docs.dto.response.InstallmentListResponseDTO;
import com.asaas.docs.dto.response.InstallmentResponseDTO;
import com.asaas.docs.dto.response.InstallmentSplitsResponseDTO;
import com.asaas.docs.dto.response.PaymentsListResponseDTO;
import com.asaas.docs.enums.PaymentStatus;
import com.asaas.docs.exception.AsaasApiException;
import com.asaas.docs.service.installments.InstallmentsService;
import com.asaas.docs.util.AsaasUtil;
import com.google.gson.Gson;
import lombok.NonNull;

import static com.asaas.docs.util.AsaasUtil.getParamsListBase;

public class InstallmentsServiceImpl implements InstallmentsService {

    private final Gson gson = new Gson();

    @Override
    public InstallmentResponseDTO createInstallment(@NonNull InstallmentRequestDTO request) {

        try {
            String response = BaseClient.postRequest(AsaasUtil.CREATE_INSTALLMENT, gson.toJson(request));
            return gson.fromJson(response, InstallmentResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public InstallmentListResponseDTO installmentList(Integer offset, Integer limit) {

        var query = getParamsListBase(offset, limit);

        try {
            String response = BaseClient.getRequest(AsaasUtil.LIST_INSTALLMENTS, query);
            return gson.fromJson(response, InstallmentListResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public InstallmentResponseDTO getInstallment(@NonNull String id) {

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.GET_INSTALLMENT, id), null);
            return gson.fromJson(response, InstallmentResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public DeleteResponseDTO deleteInstallment(@NonNull String id) {

        try {
            String response = BaseClient.deleteRequest(String.format(AsaasUtil.DELETE_INSTALLMENT, id));
            return gson.fromJson(response, DeleteResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PaymentsListResponseDTO paymentsListOfAInstallment(@NonNull String id, PaymentStatus status) {

        var query = AsaasUtil.getParamsPaymentListOfAInstallment(status);

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.LIST_PAYMENTS_OF_A_INSTALLMENT, id), query);
            return gson.fromJson(response, PaymentsListResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public String generateInstallmentBooklet(@NonNull String id, String sort, String order) {

        var query = AsaasUtil.getParamsGenerateInstallmentBooklet(sort, order);

        try {
            return BaseClient.getRequest(String.format(AsaasUtil.GENERATE_INSTALLMENT_BOOKLET, id), query);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public InstallmentResponseDTO refundInstallment(@NonNull String id) {

        try {
            String response = BaseClient.postRequest(String.format(AsaasUtil.REFUND_INSTALLMENT, id), null);
            return gson.fromJson(response, InstallmentResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public InstallmentSplitsResponseDTO updateInstallmentSplits(@NonNull String id,
                                                                @NonNull InstallmentSplitsRequestDTO request) {

        try {
            String response = BaseClient.putRequest(String.format(AsaasUtil.UPDATE_INSTALLMENT_SPLITS, id), gson.toJson(request));
            return gson.fromJson(response, InstallmentSplitsResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }
}
