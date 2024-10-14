package com.asaas.docs.util;

import com.asaas.docs.enums.BillingType;
import com.asaas.docs.enums.StatusInvoice;
import com.asaas.docs.enums.StatusPayment;
import com.asaas.docs.enums.StatusSplit;

import java.util.Collection;

public class AsaasUtil {

    // TODO Payments
    public static final String CREATE_PAYMENT = "payments";
    public static final String LIST_PAYMENTS = "payments";
    public static final String CAPTURE_PAYMENT_PRE_AUTHORIZE = "payments/%s/captureAuthorizedPayment";
    public static final String PAY_WITH_CREDIT_CARD = "payments/%s/payWithCreditCard";
    public static final String RETRIEVE_PAYMENT_BILLING_INFO = "payments/%s/billingInfo";
    public static final String PAYMENT_VIEWING_INFO = "payments/%s/viewingInfo";
    public static final String GET_PAYMENT = "payments/%s";
    public static final String UPDATE_PAYMENT = "payments/%s";
    public static final String DELETE_PAYMENT = "payments/%s";
    public static final String RESTORE_PAYMENT = "payments/%s/restore";
    public static final String RETRIEVE_PAYMENT_STATUS = "payments/%s/status";
    public static final String REFUND_PAYMENT = "payments/%s/refund";
    public static final String GET_DIGITABLE_BILL_LINE = "payments/%s/identificationField";
    public static final String GET_PIX_QR_CODE = "payments/%s/pixQrCode";
    public static final String CONFIRM_CASH_RECEIPT = "payments/%s/receiveInCash";
    public static final String UNDO_CASH_RECEIPT = "payments/%s/undoReceivedInCash";
    public static final String SALES_SIMULATION = "payments/simulate";
    public static final String RECOVERING_PAYMENT_LIMITS = "payments/limits";
    public static final String GET_CHARGEBACK = "payments/%s/chargeback";

    // TODO Payment Summary
    public static final String CREATE_SUMMARY_PAYMENT = "lean/payments";
    public static final String SUMMARY_LIST_PAYMENT = "lean/payments";
    public static final String CAPTURE_SUMMARY_PAYMENT_PRE_AUTHORIZATION = "lean/payments/%s/captureAuthorizedPayment";
    public static final String GET_SUMMARY_PAYMENT = "lean/payments/%s";
    public static final String UPDATE_SUMMARY_PAYMENT = "lean/payments/%s";
    public static final String DELETE_SUMMARY_PAYMENT = "lean/payments/%s";
    public static final String RESTORE_SUMMARY_PAYMENT = "lean/payments/%s/restore";
    public static final String REFUND_SUMMARY_PAYMENT = "lean/payments/%s/refund";
    public static final String CONFIRM_CASH_RECEIPT_SUMMARY = "lean/payments/%s/receiveInCash";
    public static final String UNDO_CASH_RECEIPT_SUMMARY = "lean/payments/%s/undoReceivedInCash";

    // TODO CreditCard
    public static final String TOKENIZE_CREDIT_CARD = "creditCard/tokenizeCreditCard";

    // TODO Bank Slip
    public static final String BANK_SLIP_REFUND = "payments/%s/bankSlip/refund";

    // TODO Split
    public static final String GET_SPLIT_PAID = "payments/splits/paid/%s";
    public static final String LIST_SPLITS_PAID = "payments/splits/paid";
    public static final String GET_SPLIT_RECEIVED = "payments/splits/received/%s";
    public static final String LIST_SPLITS_RECEIVED = "payments/splits/received";

    // TODO Document
    public static final String UPLOAD_DOCUMENT_PAYMENT = "payments/%s/documents";
    public static final String LIST_DOCUMENTS_PAYMENT = "payments/%s/documents";
    public static final String UPDATE_SETTINGS_DOCUMENT_PAYMENT = "payments/%s/documents/%s";
    public static final String RETRIEVE_DOCUMENT_PAYMENT = "payments/%s/documents/%s";
    public static final String DELETE_DOCUMENT_PAYMENT = "payments/%s/documents/%s";


    public static String getParamsListPayment(String installment, Integer offset, Integer limit, String customer,
                                              String customerGroupName, BillingType billingType,
                                              StatusPayment status, String subscription, String externalReference,
                                              String paymentDate, StatusInvoice invoiceStatus,
                                              String estimatedCreditDate, String pixQrCodeId, Boolean anticipated,
                                              Boolean anticipable, String dateCreatedGe, String dateCreatedLe,
                                              String estimatedCreditDateGe, String estimatedCreditDateLe,
                                              String dueDataGe, String dueDateLe, String user) {

        StringBuilder params = new StringBuilder();

        if (!isEmpty(installment)) {
            params.append("?installment=").append(installment);
        }

        if (offset != null) {
            if (isEmpty(params.toString())) {
                params.append("?offset=").append(offset);
            } else {
                params.append("&offset=").append(offset);
            }
        }

        if (limit != null) {
            if (isEmpty(params.toString())) {
                params.append("?limit=").append(limit);
            } else {
                params.append("&limit=").append(limit);
            }
        }

        if (!isEmpty(customer)) {
            if (isEmpty(params.toString())) {
                params.append("?customer=").append(customer);
            } else {
                params.append("&customer=").append(customer);
            }
        }

        if (!isEmpty(customerGroupName)) {
            if (isEmpty(params.toString())) {
                params.append("?customerGroupName=").append(customerGroupName);
            } else {
                params.append("&customerGroupName=").append(customerGroupName);
            }
        }

        if (billingType != null) {
            if (isEmpty(params.toString())) {
                params.append("?billingType=").append(billingType.name());
            } else {
                params.append("&billingType=").append(billingType.name());
            }
        }

        if (status != null) {
            if (isEmpty(params.toString())) {
                params.append("?status=").append(status.name());
            } else {
                params.append("&status=").append(status.name());
            }
        }

        if (!isEmpty(subscription)) {
            if (isEmpty(params.toString())) {
                params.append("?subscription=").append(subscription);
            } else {
                params.append("&subscription=").append(subscription);
            }
        }

        if (!isEmpty(externalReference)) {
            if (isEmpty(params.toString())) {
                params.append("?externalReference=").append(externalReference);
            } else {
                params.append("&externalReference=").append(externalReference);
            }
        }

        if (!isEmpty(paymentDate)) {
            if (isEmpty(params.toString())) {
                params.append("?paymentDate=").append(paymentDate);
            } else {
                params.append("&paymentDate=").append(paymentDate);
            }
        }

        if (invoiceStatus != null) {
            if (isEmpty(params.toString())) {
                params.append("?invoiceStatus=").append(invoiceStatus.name());
            } else {
                params.append("&invoiceStatus=").append(invoiceStatus.name());
            }
        }

        if (!isEmpty(estimatedCreditDate)) {
            if (isEmpty(params.toString())) {
                params.append("?estimatedCreditDate=").append(estimatedCreditDate);
            } else {
                params.append("&estimatedCreditDate=").append(estimatedCreditDate);
            }
        }

        if (!isEmpty(pixQrCodeId)) {
            if (isEmpty(params.toString())) {
                params.append("?pixQrCodeId=").append(pixQrCodeId);
            } else {
                params.append("&pixQrCodeId=").append(pixQrCodeId);
            }
        }

        if (anticipated != null) {
            if (isEmpty(params.toString())) {
                params.append("?anticipated=").append(anticipated);
            } else {
                params.append("&anticipated=").append(anticipated);
            }
        }

        if (anticipable != null) {
            if (isEmpty(params.toString())) {
                params.append("?anticipable=").append(anticipable);
            } else {
                params.append("&anticipable=").append(anticipable);
            }
        }

        if (!isEmpty(dateCreatedGe)) {
            if (isEmpty(params.toString())) {
                params.append("?dateCreatedGe=").append(dateCreatedGe);
            } else {
                params.append("&dateCreatedGe=").append(dateCreatedGe);
            }
        }

        if (!isEmpty(dateCreatedLe)) {
            if (isEmpty(params.toString())) {
                params.append("?dateCreatedLe=").append(dateCreatedLe);
            } else {
                params.append("&dateCreatedLe=").append(dateCreatedLe);
            }
        }

        if (!isEmpty(estimatedCreditDateGe)) {
            if (isEmpty(params.toString())) {
                params.append("?estimatedCreditDateGe=").append(estimatedCreditDateGe);
            } else {
                params.append("&estimatedCreditDateGe=").append(estimatedCreditDateGe);
            }
        }

        if (!isEmpty(estimatedCreditDateLe)) {
            if (isEmpty(params.toString())) {
                params.append("?estimatedCreditDateLe=").append(estimatedCreditDateLe);
            } else {
                params.append("&estimatedCreditDateLe=").append(estimatedCreditDateLe);
            }
        }

        if (!isEmpty(dueDataGe)) {
            if (isEmpty(params.toString())) {
                params.append("?dueDataGe=").append(dueDataGe);
            } else {
                params.append("&dueDataGe=").append(dueDataGe);
            }
        }

        if (!isEmpty(dueDateLe)) {
            if (isEmpty(params.toString())) {
                params.append("?dueDateLe=").append(dueDateLe);
            } else {
                params.append("&dueDateLe=").append(dueDateLe);
            }
        }

        if (!isEmpty(user)) {
            if (isEmpty(params.toString())) {
                params.append("?user=").append(user);
            } else {
                params.append("&user=").append(user);
            }
        }

        return params.toString();
    }

    public static String getParamsListSplit(Integer offset, Integer limit, String paymentId, StatusSplit status,
                                            String paymentConfirmedDateGe, String paymentConfirmedDateLe,
                                            String creditDateGe, String creditDateLe) {
        StringBuilder params = new StringBuilder();

        if (offset != null) {
            params.append("?offset=").append(offset);
        }

        if (limit != null) {
            if (isEmpty(params.toString())) {
                params.append("?limit=").append(limit);
            } else {
                params.append("&limit=").append(limit);
            }
        }

        if (!isEmpty(paymentId)) {
            if (isEmpty(params.toString())) {
                params.append("?paymentId=").append(paymentId);
            } else {
                params.append("&paymentId=").append(paymentId);
            }
        }

        if (status != null) {
            if (isEmpty(params.toString())) {
                params.append("?status=").append(status.name());
            } else {
                params.append("&status=").append(status.name());
            }
        }

        if (!isEmpty(paymentConfirmedDateGe)) {
            if (isEmpty(params.toString())) {
                params.append("?paymentConfirmedDateGe=").append(paymentConfirmedDateGe);
            } else {
                params.append("&paymentConfirmedDateGe=").append(paymentConfirmedDateGe);
            }
        }

        if (!isEmpty(paymentConfirmedDateLe)) {
            if (isEmpty(params.toString())) {
                params.append("?paymentConfirmedDateLe=").append(paymentConfirmedDateLe);
            } else {
                params.append("&paymentConfirmedDateLe=").append(paymentConfirmedDateLe);
            }
        }

        if (!isEmpty(creditDateGe)) {
            if (isEmpty(params.toString())) {
                params.append("?creditDateGe=").append(creditDateGe);
            } else {
                params.append("&creditDateGe=").append(creditDateGe);
            }
        }

        if (!isEmpty(creditDateLe)) {
            if (isEmpty(params.toString())) {
                params.append("?creditDateLe=").append(creditDateLe);
            } else {
                params.append("&creditDateLe=").append(creditDateLe);
            }
        }

        return params.toString();
    }

    public static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

}
