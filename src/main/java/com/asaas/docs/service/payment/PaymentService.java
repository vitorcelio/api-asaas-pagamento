package com.asaas.docs.service.payment;

import com.asaas.docs.dto.request.*;
import com.asaas.docs.dto.response.*;
import com.asaas.docs.enums.BillingType;
import com.asaas.docs.enums.StatusInvoice;
import com.asaas.docs.enums.StatusPayment;
import lombok.NonNull;

import java.util.List;

public interface PaymentService {


    PaymentResponseDTO createPayment(@NonNull PaymentRequestDTO request);


    List<PaymentResponseDTO> paymentsList(String installment, int offset, int limit, String customer,
                                          String customerGroupName, BillingType billingType, StatusPayment status,
                                          String subscription, String externalReference, String paymentDate,
                                          StatusInvoice invoiceStatus, String estimatedCreditDate, String pixQrCodeId,
                                          boolean anticipated, boolean anticipable, String dateCreatedGe,
                                          String dateCreatedLe, String estimatedCreditDateGe,
                                          String estimatedCreditDateLe,
                                          String dueDataGe, String dueDateLe, String user);

    PaymentResponseDTO capturePaymentPreAuthorization(@NonNull String id);

    PaymentResponseDTO payWithCreditCard(@NonNull String id, @NonNull CreditCardRequestDTO request);

    PaymentBillingInfoResponseDTO retrievePaymentBillingInfo(@NonNull String id);

    PaymentViewingInfoResponseDTO paymentViewingInfo(@NonNull String id);

    PaymentDeleteResponseDTO deletePayment(@NonNull String id);

    PaymentResponseDTO getPayment(@NonNull String id);

    PaymentResponseDTO updatePayment(@NonNull String id, @NonNull PaymentUpdateRequestDTO request);

    PaymentResponseDTO restorePayment(@NonNull String id);

    PaymentStatusResponseDTO retrievePaymentStatus(@NonNull String id);

    PaymentResponseDTO refundPayment(@NonNull String id, @NonNull PaymentRefundRequestDTO request);

    BankSlipResponseDTO getDigitableBillLines(@NonNull String id);

    PixResponseDTO getQrCodePix(@NonNull String id);

    PaymentResponseDTO confirmCashReceipt(@NonNull String id, @NonNull PaymentReceiptCashRequestDTO request);

    PaymentResponseDTO undoCashReceipt(@NonNull String id);

    SalesSimulationResponseDTO salesSimulation(@NonNull SalesSimulationRequestDTO request);

    RecoveringPaymentLimitsResponseDTO recoveringPaymentLimits();

    ChargebackResponseDTO getChargeback(@NonNull String id);
}
