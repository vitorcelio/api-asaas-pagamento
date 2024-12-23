package com.asaas.docs.service.payment;

import com.asaas.docs.dto.request.PaymentReceiptCashRequestDTO;
import com.asaas.docs.dto.request.PaymentRequestDTO;
import com.asaas.docs.dto.request.PaymentUpdateRequestDTO;
import com.asaas.docs.dto.response.DeleteResponseDTO;
import com.asaas.docs.dto.response.PaymentListSummaryResponseDTO;
import com.asaas.docs.dto.response.PaymentSummaryResponseDTO;
import com.asaas.docs.enums.BillingType;
import com.asaas.docs.enums.InvoiceStatus;
import com.asaas.docs.enums.PaymentStatus;
import lombok.NonNull;

public interface PaymentSummaryService {

    PaymentSummaryResponseDTO createSummaryPayment(@NonNull PaymentRequestDTO request);

    PaymentListSummaryResponseDTO summaryPaymentsList(String installment, Integer offset, Integer limit, String customer,
                                                      String customerGroupName, BillingType billingType, PaymentStatus status,
                                                      String subscription, String externalReference, String paymentDate,
                                                      InvoiceStatus invoiceStatus, String estimatedCreditDate, String pixQrCodeId,
                                                      Boolean anticipated, Boolean anticipable, String dateCreatedGe,
                                                      String dateCreatedLe, String estimatedCreditDateGe,
                                                      String estimatedCreditDateLe,
                                                      String dueDataGe, String dueDateLe, String user);

    PaymentSummaryResponseDTO captureSummaryPaymentPreAuthorization(@NonNull String id);

    PaymentSummaryResponseDTO getSummaryPayment(@NonNull String id);

    PaymentSummaryResponseDTO updateSummaryPayment(@NonNull String id, @NonNull PaymentUpdateRequestDTO request);

    DeleteResponseDTO deleteSummaryPayment(@NonNull String id);

    PaymentSummaryResponseDTO restoreSummaryPayment(@NonNull String id);

    PaymentSummaryResponseDTO refundSummaryPayment(@NonNull String id);

    PaymentSummaryResponseDTO confirmCashReceiptSummary(@NonNull String id, @NonNull PaymentReceiptCashRequestDTO request);

    PaymentSummaryResponseDTO undoCashReceiptSummary(@NonNull String id);

}
