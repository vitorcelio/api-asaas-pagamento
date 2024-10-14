package com.asaas.docs.service.payment.impl;

import com.asaas.docs.client.BaseClient;
import com.asaas.docs.dto.request.PaymentReceiptCashRequestDTO;
import com.asaas.docs.dto.request.PaymentRequestDTO;
import com.asaas.docs.dto.request.PaymentUpdateRequestDTO;
import com.asaas.docs.dto.response.DeleteResponseDTO;
import com.asaas.docs.dto.response.PaymentListSummaryResponseDTO;
import com.asaas.docs.dto.response.PaymentSummaryResponseDTO;
import com.asaas.docs.enums.BillingType;
import com.asaas.docs.enums.StatusInvoice;
import com.asaas.docs.enums.StatusPayment;
import com.asaas.docs.exception.AsaasApiException;
import com.asaas.docs.service.payment.PaymentSummaryService;
import com.asaas.docs.util.AsaasUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.NonNull;

public class PaymentSummaryServiceImpl implements PaymentSummaryService {

    private Gson gson = new Gson();

    @Override
    public PaymentSummaryResponseDTO createSummaryPayment(@NonNull PaymentRequestDTO request) {

        try {
            String response = BaseClient.postRequest(AsaasUtil.CREATE_SUMMARY_PAYMENT, gson.toJson(request));
            return gson.fromJson(response, PaymentSummaryResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PaymentListSummaryResponseDTO summaryPaymentsList(String installment, Integer offset, Integer limit, String customer, String customerGroupName, BillingType billingType, StatusPayment status, String subscription, String externalReference, String paymentDate, StatusInvoice invoiceStatus, String estimatedCreditDate, String pixQrCodeId, Boolean anticipated, Boolean anticipable, String dateCreatedGe, String dateCreatedLe, String estimatedCreditDateGe, String estimatedCreditDateLe, String dueDataGe, String dueDateLe, String user) {

        var query = AsaasUtil.getParamsListPayment(installment, offset, limit, customer, customerGroupName, billingType,
                status, subscription, externalReference, paymentDate, invoiceStatus, estimatedCreditDate, pixQrCodeId
                , anticipated, anticipable, dateCreatedGe, dateCreatedLe, estimatedCreditDateGe,
                estimatedCreditDateLe, dueDataGe, dueDateLe, user);

        try {
            String response = BaseClient.getRequest(AsaasUtil.SUMMARY_LIST_PAYMENT, query);
            return gson.fromJson(response, PaymentListSummaryResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PaymentSummaryResponseDTO captureSummaryPaymentPreAuthorization(@NonNull String id) {

        try {
            String response = BaseClient.postRequest(String.format(AsaasUtil.CAPTURE_SUMMARY_PAYMENT_PRE_AUTHORIZATION, id), null);
            return gson.fromJson(response, PaymentSummaryResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PaymentSummaryResponseDTO getSummaryPayment(@NonNull String id) {

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.GET_SUMMARY_PAYMENT, id), null);
            return gson.fromJson(response, PaymentSummaryResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PaymentSummaryResponseDTO updateSummaryPayment(@NonNull String id, @NonNull PaymentUpdateRequestDTO request) {

        try {
            String response = BaseClient.putRequest(String.format(AsaasUtil.UPDATE_SUMMARY_PAYMENT, id), gson.toJson(request));
            return gson.fromJson(response, PaymentSummaryResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public DeleteResponseDTO deleteSummaryPayment(@NonNull String id) {

        try {
            String response = BaseClient.deleteRequest(String.format(AsaasUtil.DELETE_SUMMARY_PAYMENT, id));
            return gson.fromJson(response, DeleteResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PaymentSummaryResponseDTO restoreSummaryPayment(@NonNull String id) {

        try {
            String response = BaseClient.postRequest(String.format(AsaasUtil.RESTORE_SUMMARY_PAYMENT, id), null);
            return gson.fromJson(response, PaymentSummaryResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PaymentSummaryResponseDTO refundSummaryPayment(@NonNull String id) {

        try {
            gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
            String response = BaseClient.postRequest(String.format(AsaasUtil.REFUND_SUMMARY_PAYMENT, id), null);
            return gson.fromJson(response, PaymentSummaryResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PaymentSummaryResponseDTO confirmCashReceiptSummary(@NonNull String id, @NonNull PaymentReceiptCashRequestDTO request) {

        try {
            String response = BaseClient.postRequest(String.format(AsaasUtil.CONFIRM_CASH_RECEIPT_SUMMARY, id), gson.toJson(request));
            return gson.fromJson(response, PaymentSummaryResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PaymentSummaryResponseDTO undoCashReceiptSummary(@NonNull String id) {

        try {
            String response = BaseClient.postRequest(String.format(AsaasUtil.UNDO_CASH_RECEIPT_SUMMARY, id), null);
            return gson.fromJson(response, PaymentSummaryResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

}
