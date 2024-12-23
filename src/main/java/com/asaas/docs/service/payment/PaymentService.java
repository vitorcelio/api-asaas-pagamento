package com.asaas.docs.service.payment;

import com.asaas.docs.dto.request.PaymentReceiptCashRequestDTO;
import com.asaas.docs.dto.request.PaymentRefundRequestDTO;
import com.asaas.docs.dto.request.PaymentRequestDTO;
import com.asaas.docs.dto.request.PaymentUpdateRequestDTO;
import com.asaas.docs.dto.request.SalesSimulationRequestDTO;
import com.asaas.docs.dto.response.*;
import com.asaas.docs.enums.BillingType;
import com.asaas.docs.enums.InvoiceStatus;
import com.asaas.docs.enums.PaymentStatus;
import lombok.NonNull;

public interface PaymentService {


    PaymentResponseDTO createPayment(@NonNull PaymentRequestDTO request);


    PaymentsListResponseDTO paymentsList(String installment, Integer offset, Integer limit, String customer,
                                         String customerGroupName, BillingType billingType, PaymentStatus status,
                                         String subscription, String externalReference, String paymentDate,
                                         InvoiceStatus invoiceStatus, String estimatedCreditDate, String pixQrCodeId,
                                         Boolean anticipated, Boolean anticipable, String dateCreatedGe,
                                         String dateCreatedLe, String estimatedCreditDateGe,
                                         String estimatedCreditDateLe,
                                         String dueDataGe, String dueDateLe, String user);

    PaymentResponseDTO capturePaymentPreAuthorization(@NonNull String id);

    PaymentResponseDTO payWithCreditCard(@NonNull String id, @NonNull PaymentRequestDTO request);

    PaymentBillingInfoResponseDTO retrievePaymentBillingInfo(@NonNull String id);

    PaymentViewingInfoResponseDTO paymentViewingInfo(@NonNull String id);

    DeleteResponseDTO deletePayment(@NonNull String id);

    PaymentResponseDTO getPayment(@NonNull String id);

    PaymentResponseDTO updatePayment(@NonNull String id, @NonNull PaymentUpdateRequestDTO request);

    PaymentResponseDTO restorePayment(@NonNull String id);

    PaymentStatusResponseDTO retrievePaymentStatus(@NonNull String id);

    PaymentResponseDTO refundPayment(@NonNull String id, @NonNull PaymentRefundRequestDTO request);

    BankSlipResponseDTO getDigitableBillLines(@NonNull String id);

    PixPaymentResponseDTO getQrCodePix(@NonNull String id);

    PaymentResponseDTO confirmCashReceipt(@NonNull String id, @NonNull PaymentReceiptCashRequestDTO request);

    PaymentResponseDTO undoCashReceipt(@NonNull String id);

    SalesSimulationResponseDTO salesSimulation(@NonNull SalesSimulationRequestDTO request);

    RecoveringPaymentLimitsResponseDTO recoveringPaymentLimits();

    ChargebackResponseDTO getChargeback(@NonNull String id);
}
