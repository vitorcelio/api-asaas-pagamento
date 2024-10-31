package com.asaas.docs.util;

import com.asaas.docs.enums.*;

import java.util.Collection;

public class AsaasUtil {

    // Payments
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

    // Payment Summary
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

    // Credit Card
    public static final String TOKENIZE_CREDIT_CARD = "creditCard/tokenizeCreditCard";

    // Bank Slip
    public static final String BANK_SLIP_REFUND = "payments/%s/bankSlip/refund";

    // Split
    public static final String GET_SPLIT_PAID = "payments/splits/paid/%s";
    public static final String LIST_SPLITS_PAID = "payments/splits/paid";
    public static final String GET_SPLIT_RECEIVED = "payments/splits/received/%s";
    public static final String LIST_SPLITS_RECEIVED = "payments/splits/received";

    // Document
    public static final String UPLOAD_DOCUMENT_PAYMENT = "payments/%s/documents";
    public static final String LIST_DOCUMENTS_PAYMENT = "payments/%s/documents";
    public static final String UPDATE_SETTINGS_DOCUMENT_PAYMENT = "payments/%s/documents/%s";
    public static final String RETRIEVE_DOCUMENT_PAYMENT = "payments/%s/documents/%s";
    public static final String DELETE_DOCUMENT_PAYMENT = "payments/%s/documents/%s";

    // Customer
    public static final String CREATE_CUSTOMER = "customers";
    public static final String LIST_CUSTOMERS = "customers";
    public static final String GET_CUSTOMER = "customers/%s";
    public static final String UPDATE_CUSTOMER = "customers/%s";
    public static final String DELETE_CUSTOMER = "customers/%s";
    public static final String RESTORE_CUSTOMER = "customers/%s/restore";
    public static final String RETRIEVE_NOTIFICATIONS_CUSTOMER = "customers/%s/notifications";

    // Notification
    public static final String UPDATE_EXISTING_NOTIFICATION = "notifications/%s";
    public static final String UPDATE_EXISTING_NOTIFICATIONS_BATCH = "notifications/batch";

    // Installment
    public static final String CREATE_INSTALLMENT = "installments";
    public static final String LIST_INSTALLMENTS = "installments";
    public static final String GET_INSTALLMENT = "installments/%s";
    public static final String DELETE_INSTALLMENT = "installments/%s";
    public static final String LIST_PAYMENTS_OF_A_INSTALLMENT = "installments/%s/payments";
    public static final String GENERATE_INSTALLMENT_BOOKLET = "installments/%s/paymentBook";
    public static final String REFUND_INSTALLMENT = "installments/%s/refund";
    public static final String UPDATE_INSTALLMENT_SPLITS = "installments/%s/splits";

    // Subscription
    public static final String CREATE_SUBSCRIPTION = "subscriptions";
    public static final String LIST_SUBSCRIPTIONS = "subscriptions";
    public static final String GET_SUBSCRIPTION = "subscriptions/%s";
    public static final String UPDATE_SUBSCRIPTION = "subscriptions/%s";
    public static final String DELETE_SUBSCRIPTION = "subscriptions/%s";
    public static final String LIST_PAYMENTS_OF_A_SUBSCRIPTION = "subscriptions/%s/payments";
    public static final String GENERATE_SUBSCRIPTION_BOOKLET = "subscriptions/%s/paymentBook";
    public static final String CREATE_CONFIGURATION_FOR_ISSUING_INVOICES = "subscriptions/%s/invoiceSettings";
    public static final String RETRIEVE_CONFIGURATION_FOR_ISSUING_INVOICES = "subscriptions/%s/invoiceSettings";
    public static final String REMOVE_CONFIGURATION_FOR_ISSUING_INVOICES = "subscriptions/%s/invoiceSettings";
    public static final String UPDATE_CONFIGURATION_FOR_ISSUING_INVOICES = "subscriptions/%s/invoiceSettings";
    public static final String LIST_INVOICES_FOR_SUBSCRIPTION = "subscriptions/%s/invoices";


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
                params.append("?dateCreated[ge]=").append(dateCreatedGe);
            } else {
                params.append("&dateCreated[ge]=").append(dateCreatedGe);
            }
        }

        if (!isEmpty(dateCreatedLe)) {
            if (isEmpty(params.toString())) {
                params.append("?dateCreated[le]=").append(dateCreatedLe);
            } else {
                params.append("&dateCreated[le]=").append(dateCreatedLe);
            }
        }

        if (!isEmpty(estimatedCreditDateGe)) {
            if (isEmpty(params.toString())) {
                params.append("?estimatedCreditDate[ge]=").append(estimatedCreditDateGe);
            } else {
                params.append("&estimatedCreditDate[ge]=").append(estimatedCreditDateGe);
            }
        }

        if (!isEmpty(estimatedCreditDateLe)) {
            if (isEmpty(params.toString())) {
                params.append("?estimatedCreditDate[le]=").append(estimatedCreditDateLe);
            } else {
                params.append("&estimatedCreditDate[le]=").append(estimatedCreditDateLe);
            }
        }

        if (!isEmpty(dueDataGe)) {
            if (isEmpty(params.toString())) {
                params.append("?dueData[ge]=").append(dueDataGe);
            } else {
                params.append("&dueData[ge]=").append(dueDataGe);
            }
        }

        if (!isEmpty(dueDateLe)) {
            if (isEmpty(params.toString())) {
                params.append("?dueDate[le]=").append(dueDateLe);
            } else {
                params.append("&dueDate[le]=").append(dueDateLe);
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
                params.append("?paymentConfirmedDate[ge]=").append(paymentConfirmedDateGe);
            } else {
                params.append("&paymentConfirmedDate[ge]=").append(paymentConfirmedDateGe);
            }
        }

        if (!isEmpty(paymentConfirmedDateLe)) {
            if (isEmpty(params.toString())) {
                params.append("?paymentConfirmedDate[le]=").append(paymentConfirmedDateLe);
            } else {
                params.append("&paymentConfirmedDate[le]=").append(paymentConfirmedDateLe);
            }
        }

        if (!isEmpty(creditDateGe)) {
            if (isEmpty(params.toString())) {
                params.append("?creditDate[ge]=").append(creditDateGe);
            } else {
                params.append("&creditDate[ge]=").append(creditDateGe);
            }
        }

        if (!isEmpty(creditDateLe)) {
            if (isEmpty(params.toString())) {
                params.append("?creditDate[le]=").append(creditDateLe);
            } else {
                params.append("&creditDate[le]=").append(creditDateLe);
            }
        }

        return params.toString();
    }

    public static String getParamsListCustomer(Integer offset, Integer limit, String name, String email,
                                               String cpfCnpj, String groupName, String externalReference) {
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

        if (!isEmpty(name)) {
            if (isEmpty(params.toString())) {
                params.append("?name=").append(name);
            } else {
                params.append("&name=").append(name);
            }
        }

        if (!isEmpty(email)) {
            if (isEmpty(params.toString())) {
                params.append("?email=").append(email);
            } else {
                params.append("&email=").append(email);
            }
        }

        if (!isEmpty(cpfCnpj)) {
            if (isEmpty(params.toString())) {
                params.append("?cpfCnpj=").append(cpfCnpj);
            } else {
                params.append("&cpfCnpj=").append(cpfCnpj);
            }
        }

        if (!isEmpty(groupName)) {
            if (isEmpty(params.toString())) {
                params.append("?groupName=").append(groupName);
            } else {
                params.append("&groupName=").append(groupName);
            }
        }

        if (!isEmpty(externalReference)) {
            if (isEmpty(params.toString())) {
                params.append("?externalReference=").append(externalReference);
            } else {
                params.append("&externalReference=").append(externalReference);
            }
        }

        return params.toString();
    }

    public static String getParamsListInstallment(Integer offset, Integer limit) {
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

        return params.toString();
    }

    public static String getParamsPaymentListOfAInstallment(StatusPayment status) {
        StringBuilder params = new StringBuilder();

        if (status != null) {
            params.append("?status=").append(status.name());
        }

        return params.toString();
    }

    public static String getParamsGenerateInstallmentBooklet(String sort, String order) {
        StringBuilder params = new StringBuilder();

        if (!isEmpty(sort)) {
            params.append("?sort=").append(sort);
        }

        if (!isEmpty(order)) {
            if (isEmpty(params.toString())) {
                params.append("?order=").append(order);
            } else {
                params.append("&order=").append(order);
            }
        }

        return params.toString();
    }

    public static String getParamsListSubscriptions(Integer offset, Integer limit, String customer,
                                                    String customerGroupName, BillingType billingType,
                                                    StatusSubscription status, Boolean deletedOnly,
                                                    Boolean includeDeleted, String externalReference, String order,
                                                    String sort) {
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

        if (deletedOnly != null) {
            if (isEmpty(params.toString())) {
                params.append("?deletedOnly=").append(deletedOnly);
            } else {
                params.append("&deletedOnly=").append(deletedOnly);
            }
        }

        if (includeDeleted != null) {
            if (isEmpty(params.toString())) {
                params.append("?includeDeleted=").append(includeDeleted);
            } else {
                params.append("&includeDeleted=").append(includeDeleted);
            }
        }

        if (!isEmpty(externalReference)) {
            if (isEmpty(params.toString())) {
                params.append("?externalReference=").append(externalReference);
            } else {
                params.append("&externalReference=").append(externalReference);
            }
        }

        if (!isEmpty(order)) {
            if (isEmpty(params.toString())) {
                params.append("?order=").append(order);
            } else {
                params.append("&order=").append(order);
            }
        }

        if (!isEmpty(sort)) {
            if (isEmpty(params.toString())) {
                params.append("?sort=").append(sort);
            } else {
                params.append("&sort=").append(sort);
            }
        }

        return params.toString();
    }

    public static String getParamsGenerateSubscriptionBooklet(Integer month, Integer year, String sort, String order) {
        StringBuilder params = new StringBuilder();

        if (month != null) {
            params.append("?month=").append(month);
        }

        if (year != null) {
            if (isEmpty(params.toString())) {
                params.append("?year=").append(year);
            } else {
                params.append("&year=").append(year);
            }
        }

        if (!isEmpty(sort)) {
            if (isEmpty(params.toString())) {
                params.append("?sort=").append(sort);
            } else {
                params.append("&sort=").append(sort);
            }
        }

        if (!isEmpty(order)) {
            if (isEmpty(params.toString())) {
                params.append("?order=").append(order);
            } else {
                params.append("&order=").append(order);
            }
        }

        return params.toString();
    }

    public static String getParamsListInvoicesForSubscription(Integer offset, Integer limit, String effectiveDateGe,
                                                              String effectiveDateLe, String externalReference,
                                                              StatusInvoice status, String customer) {
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

        if (!isEmpty(effectiveDateGe)) {
            if (isEmpty(params.toString())) {
                params.append("?effectiveDate[ge]=").append(effectiveDateGe);
            } else {
                params.append("&effectiveDate[ge]=").append(effectiveDateGe);
            }
        }

        if (!isEmpty(effectiveDateLe)) {
            if (isEmpty(params.toString())) {
                params.append("?effectiveDate[le]=").append(effectiveDateLe);
            } else {
                params.append("&effectiveDate[le]=").append(effectiveDateLe);
            }
        }

        if (!isEmpty(externalReference)) {
            if (isEmpty(params.toString())) {
                params.append("?externalReference=").append(externalReference);
            } else {
                params.append("&externalReference=").append(externalReference);
            }
        }

        if (status != null) {
            if (isEmpty(params.toString())) {
                params.append("?status=").append(status.name());
            } else {
                params.append("&status=").append(status.name());
            }
        }

        if (!isEmpty(customer)) {
            if (isEmpty(params.toString())) {
                params.append("?customer=").append(customer);
            } else {
                params.append("&customer=").append(customer);
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
