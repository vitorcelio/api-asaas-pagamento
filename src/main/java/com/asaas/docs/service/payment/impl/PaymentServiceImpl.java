package com.asaas.docs.service.payment.impl;

import com.asaas.docs.client.BaseClient;
import com.asaas.docs.dto.request.*;
import com.asaas.docs.dto.response.*;
import com.asaas.docs.enums.BillingType;
import com.asaas.docs.enums.StatusInvoice;
import com.asaas.docs.enums.StatusPayment;
import com.asaas.docs.exception.AsaasApiException;
import com.asaas.docs.exception.AsaasErrorResponse;
import com.asaas.docs.service.payment.PaymentService;
import com.asaas.docs.util.AsaasUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.NonNull;

public class PaymentServiceImpl implements PaymentService {

    private Gson gson = new Gson();

    @Override
    public PaymentResponseDTO createPayment(@NonNull PaymentRequestDTO request) {

        try {
            String response = BaseClient.postRequest(AsaasUtil.CREATE_PAYMENT, gson.toJson(request));
            return gson.fromJson(response, PaymentResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PaymentListResponseDTO paymentsList(String installment, Integer offset, Integer limit, String customer,
                                               String customerGroupName, BillingType billingType,
                                               StatusPayment status, String subscription, String externalReference,
                                               String paymentDate, StatusInvoice invoiceStatus,
                                               String estimatedCreditDate, String pixQrCodeId, Boolean anticipated,
                                               Boolean anticipable, String dateCreatedGe, String dateCreatedLe,
                                               String estimatedCreditDateGe, String estimatedCreditDateLe,
                                               String dueDataGe, String dueDateLe, String user) {

        var query = AsaasUtil.getParamsList(installment, offset, limit, customer, customerGroupName, billingType,
                status, subscription, externalReference, paymentDate, invoiceStatus, estimatedCreditDate, pixQrCodeId
                , anticipated, anticipable, dateCreatedGe, dateCreatedLe, estimatedCreditDateGe,
                estimatedCreditDateLe, dueDataGe, dueDateLe, user);

        try {
            String response = BaseClient.getRequest(AsaasUtil.LIST_PAYMENT, query);
            return gson.fromJson(response, PaymentListResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PaymentResponseDTO capturePaymentPreAuthorization(@NonNull String id) {

        try {
            String response = BaseClient.postRequest(String.format(AsaasUtil.CAPTURE_PAYMENT_PRE_AUTHORIZE, id), null);
            return gson.fromJson(response, PaymentResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PaymentResponseDTO payWithCreditCard(@NonNull String id, @NonNull PaymentRequestDTO request) {

        try {
            String response = BaseClient.postRequest(String.format(AsaasUtil.PAY_WITH_CREDIT_CARD, id),
                    gson.toJson(request));
            return gson.fromJson(response, PaymentResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PaymentBillingInfoResponseDTO retrievePaymentBillingInfo(@NonNull String id) {

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.RETRIEVE_PAYMENT_BILLING_INFO, id), null);
            return gson.fromJson(response, PaymentBillingInfoResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PaymentViewingInfoResponseDTO paymentViewingInfo(@NonNull String id) {

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.PAYMENT_VIEWING_INFO, id), null);
            return gson.fromJson(response, PaymentViewingInfoResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PaymentDeleteResponseDTO deletePayment(@NonNull String id) {

        try {
            String response = BaseClient.deleteRequest(String.format(AsaasUtil.DELETE_PAYMENT, id));
            return gson.fromJson(response, PaymentDeleteResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PaymentResponseDTO getPayment(@NonNull String id) {

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.GET_PAYMENT, id), null);
            return gson.fromJson(response, PaymentResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PaymentResponseDTO updatePayment(@NonNull String id, @NonNull PaymentUpdateRequestDTO request) {

        try {
            String response = BaseClient.putRequest(String.format(AsaasUtil.UPDATE_PAYMENT, id), gson.toJson(request));
            return gson.fromJson(response, PaymentResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PaymentResponseDTO restorePayment(@NonNull String id) {

        try {
            String response = BaseClient.postRequest(String.format(AsaasUtil.RESTORE_PAYMENT, id), null);
            return gson.fromJson(response, PaymentResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PaymentStatusResponseDTO retrievePaymentStatus(@NonNull String id) {

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.RETRIEVE_PAYMENT_STATUS, id), null);
            return gson.fromJson(response, PaymentStatusResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PaymentResponseDTO refundPayment(@NonNull String id, @NonNull PaymentRefundRequestDTO request) {

        try {
            gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
            String response = BaseClient.postRequest(String.format(AsaasUtil.REFUND_PAYMENT, id), gson.toJson(request));
            return gson.fromJson(response, PaymentResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public BankSlipResponseDTO getDigitableBillLines(@NonNull String id) {

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.GET_DIGITABLE_BILL_LINE, id), null);
            return gson.fromJson(response, BankSlipResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PixResponseDTO getQrCodePix(@NonNull String id) {

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.GET_PIX_QR_CODE, id), null);
            return gson.fromJson(response, PixResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PaymentResponseDTO confirmCashReceipt(@NonNull String id, @NonNull PaymentReceiptCashRequestDTO request) {

        try {
            String response = BaseClient.postRequest(String.format(AsaasUtil.CONFIRM_CASH_RECEIPT, id), gson.toJson(request));
            return gson.fromJson(response, PaymentResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PaymentResponseDTO undoCashReceipt(@NonNull String id) {

        try {
            String response = BaseClient.postRequest(String.format(AsaasUtil.UNDO_CASH_RECEIPT, id), null);
            return gson.fromJson(response, PaymentResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public SalesSimulationResponseDTO salesSimulation(@NonNull SalesSimulationRequestDTO request) {

        try {
            String response = BaseClient.postRequest(AsaasUtil.SALES_SIMULATION, gson.toJson(request));
            return gson.fromJson(response, SalesSimulationResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public RecoveringPaymentLimitsResponseDTO recoveringPaymentLimits() {

        try {
            String response = BaseClient.getRequest(AsaasUtil.RECOVERING_PAYMENT_LIMITS, null);
            return gson.fromJson(response, RecoveringPaymentLimitsResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public ChargebackResponseDTO getChargeback(@NonNull String id) {

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.GET_CHARGEBACK, id), null);
            return gson.fromJson(response, ChargebackResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

}
