package com.asaas.docs.service.payment.impl;

import com.asaas.docs.dto.request.*;
import com.asaas.docs.dto.response.*;
import com.asaas.docs.enums.BillingType;
import com.asaas.docs.enums.StatusInvoice;
import com.asaas.docs.enums.StatusPayment;
import com.asaas.docs.service.payment.PaymentService;
import lombok.NonNull;

import java.util.List;

public class PaymentServiceImpl implements PaymentService {

    @Override
    public PaymentResponseDTO createPayment(@NonNull PaymentRequestDTO request) {
        return null;
    }

    @Override
    public List<PaymentResponseDTO> paymentsList(String installment, int offset, int limit, String customer,
                                                 String customerGroupName, BillingType billingType,
                                                 StatusPayment status, String subscription, String externalReference,
                                                 String paymentDate, StatusInvoice invoiceStatus,
                                                 String estimatedCreditDate, String pixQrCodeId, boolean anticipated,
                                                 boolean anticipable, String dateCreatedGe, String dateCreatedLe,
                                                 String estimatedCreditDateGe, String estimatedCreditDateLe,
                                                 String dueDataGe, String dueDateLe, String user) {
        return List.of();
    }

    @Override
    public PaymentResponseDTO capturePaymentPreAuthorization(@NonNull String id) {
        return null;
    }

    @Override
    public PaymentResponseDTO payWithCreditCard(@NonNull String id, @NonNull CreditCardRequestDTO request) {
        return null;
    }

    @Override
    public PaymentBillingInfoResponseDTO retrievePaymentBillingInfo(@NonNull String id) {
        return null;
    }

    @Override
    public PaymentViewingInfoResponseDTO paymentViewingInfo(@NonNull String id) {
        return null;
    }

    @Override
    public PaymentDeleteResponseDTO deletePayment(@NonNull String id) {
        return null;
    }

    @Override
    public PaymentResponseDTO getPayment(@NonNull String id) {
        return null;
    }

    @Override
    public PaymentResponseDTO updatePayment(@NonNull String id, @NonNull PaymentUpdateRequestDTO request) {
        return null;
    }

    @Override
    public PaymentResponseDTO restorePayment(@NonNull String id) {
        return null;
    }

    @Override
    public PaymentStatusResponseDTO retrievePaymentStatus(@NonNull String id) {
        return null;
    }

    @Override
    public PaymentResponseDTO refundPayment(@NonNull String id, @NonNull PaymentRefundRequestDTO request) {
        return null;
    }

    @Override
    public BankSlipResponseDTO getDigitableBillLines(@NonNull String id) {
        return null;
    }

    @Override
    public PixResponseDTO getQrCodePix(@NonNull String id) {
        return null;
    }

    @Override
    public PaymentResponseDTO confirmCashReceipt(@NonNull String id, @NonNull PaymentReceiptCashRequestDTO request) {
        return null;
    }

    @Override
    public PaymentResponseDTO undoCashReceipt(@NonNull String id) {
        return null;
    }

    @Override
    public SalesSimulationResponseDTO salesSimulation(@NonNull SalesSimulationRequestDTO request) {
        return null;
    }

    @Override
    public RecoveringPaymentLimitsResponseDTO recoveringPaymentLimits() {
        return null;
    }

    @Override
    public ChargebackResponseDTO getChargeback(@NonNull String id) {
        return null;
    }

}
