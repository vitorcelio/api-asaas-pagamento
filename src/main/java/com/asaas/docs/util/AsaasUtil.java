package com.asaas.docs.util;

import com.asaas.docs.enums.BillingType;
import com.asaas.docs.enums.StatusInvoice;
import com.asaas.docs.enums.StatusPayment;

import java.util.Collection;

public class AsaasUtil {

    // TODO Payments
    public static final String CREATE_PAYMENT = "payments";
    public static final String LIST_PAYMENT = "payments";
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


    public static String getParamsList(String installment, Integer offset, Integer limit, String customer,
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

        if(!isEmpty(dateCreatedGe)) {
            if (isEmpty(params.toString())) {
                params.append("?dateCreatedGe=").append(dateCreatedGe);
            } else {
                params.append("&dateCreatedGe=").append(dateCreatedGe);
            }
        }

        if(!isEmpty(dateCreatedLe)) {
            if (isEmpty(params.toString())) {
                params.append("?dateCreatedLe=").append(dateCreatedLe);
            } else {
                params.append("&dateCreatedLe=").append(dateCreatedLe);
            }
        }

        if(!isEmpty(estimatedCreditDateGe)) {
            if (isEmpty(params.toString())) {
                params.append("?estimatedCreditDateGe=").append(estimatedCreditDateGe);
            } else {
                params.append("&estimatedCreditDateGe=").append(estimatedCreditDateGe);
            }
        }

        if(!isEmpty(estimatedCreditDateLe)) {
            if (isEmpty(params.toString())) {
                params.append("?estimatedCreditDateLe=").append(estimatedCreditDateLe);
            } else {
                params.append("&estimatedCreditDateLe=").append(estimatedCreditDateLe);
            }
        }

        if(!isEmpty(dueDataGe)) {
            if (isEmpty(params.toString())) {
                params.append("?dueDataGe=").append(dueDataGe);
            } else {
                params.append("&dueDataGe=").append(dueDataGe);
            }
        }

        if(!isEmpty(dueDateLe)) {
            if (isEmpty(params.toString())) {
                params.append("?dueDateLe=").append(dueDateLe);
            } else {
                params.append("&dueDateLe=").append(dueDateLe);
            }
        }

        if(!isEmpty(user)) {
            if (isEmpty(params.toString())) {
                params.append("?user=").append(user);
            } else {
                params.append("&user=").append(user);
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
