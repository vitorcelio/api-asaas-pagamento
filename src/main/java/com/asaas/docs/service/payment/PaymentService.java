package com.asaas.docs.service.payment;

import com.asaas.docs.dto.request.PaymentReceiptCashRequestDTO;
import com.asaas.docs.dto.request.PaymentRefundRequestDTO;
import com.asaas.docs.dto.request.PaymentRequestDTO;
import com.asaas.docs.dto.request.PaymentUpdateRequestDTO;
import com.asaas.docs.dto.request.SalesSimulationRequestDTO;
import com.asaas.docs.dto.response.BankSlipResponseDTO;
import com.asaas.docs.dto.response.ChargebackResponseDTO;
import com.asaas.docs.dto.response.PaymentBillingInfoResponseDTO;
import com.asaas.docs.dto.response.PaymentDeleteResponseDTO;
import com.asaas.docs.dto.response.PaymentListResponseDTO;
import com.asaas.docs.dto.response.PaymentResponseDTO;
import com.asaas.docs.dto.response.PaymentStatusResponseDTO;
import com.asaas.docs.dto.response.PaymentViewingInfoResponseDTO;
import com.asaas.docs.dto.response.PixResponseDTO;
import com.asaas.docs.dto.response.RecoveringPaymentLimitsResponseDTO;
import com.asaas.docs.dto.response.SalesSimulationResponseDTO;
import com.asaas.docs.enums.BillingType;
import com.asaas.docs.enums.StatusInvoice;
import com.asaas.docs.enums.StatusPayment;
import lombok.NonNull;

public interface PaymentService {


    PaymentResponseDTO createPayment(@NonNull PaymentRequestDTO request);


    PaymentListResponseDTO paymentsList(String installment, Integer offset, Integer limit, String customer,
                                        String customerGroupName, BillingType billingType, StatusPayment status,
                                        String subscription, String externalReference, String paymentDate,
                                        StatusInvoice invoiceStatus, String estimatedCreditDate, String pixQrCodeId,
                                        Boolean anticipated, Boolean anticipable, String dateCreatedGe,
                                        String dateCreatedLe, String estimatedCreditDateGe,
                                        String estimatedCreditDateLe,
                                        String dueDataGe, String dueDateLe, String user);

    PaymentResponseDTO capturePaymentPreAuthorization(@NonNull String id);

    PaymentResponseDTO payWithCreditCard(@NonNull String id, @NonNull PaymentRequestDTO request);

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
