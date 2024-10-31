package com.asaas.docs.service.subscription.impl;

import com.asaas.docs.client.BaseClient;
import com.asaas.docs.dto.request.ConfigurationIssuingInvoicesRequestDTO;
import com.asaas.docs.dto.request.ConfigurationUpdateIssuingInvoicesRequestDTO;
import com.asaas.docs.dto.request.SubscriptionRequestDTO;
import com.asaas.docs.dto.request.SubscriptionUpdateRequestDTO;
import com.asaas.docs.dto.response.*;
import com.asaas.docs.enums.BillingType;
import com.asaas.docs.enums.StatusInvoice;
import com.asaas.docs.enums.StatusPayment;
import com.asaas.docs.enums.StatusSubscription;
import com.asaas.docs.exception.AsaasApiException;
import com.asaas.docs.service.subscription.SubscriptionService;
import com.asaas.docs.util.AsaasUtil;
import com.google.gson.Gson;
import lombok.NonNull;

public class SubscriptionServiceImpl implements SubscriptionService {

    private final Gson gson = new Gson();

    @Override
    public SubscriptionResponseDTO createSubscription(@NonNull SubscriptionRequestDTO request) {

        try {
            String response = BaseClient.postRequest(AsaasUtil.CREATE_SUBSCRIPTION, gson.toJson(request));
            return gson.fromJson(response, SubscriptionResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public SubscriptionsListResponseDTO subscriptionsList(Integer offset, Integer limit, String customer,
                                                          String customerGroupName, BillingType billingType,
                                                          StatusSubscription status, Boolean deletedOnly,
                                                          Boolean includeDeleted, String externalReference,
                                                          String order, String sort) {

        var query = AsaasUtil.getParamsListSubscriptions(offset, limit, customer, customerGroupName, billingType,
                status, deletedOnly, includeDeleted, externalReference, order, sort);

        try {
            String response = BaseClient.getRequest(AsaasUtil.LIST_SUBSCRIPTIONS, query);
            return gson.fromJson(response, SubscriptionsListResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public SubscriptionResponseDTO getSubscription(@NonNull String id) {

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.GET_SUBSCRIPTION, id), null);
            return gson.fromJson(response, SubscriptionResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public SubscriptionResponseDTO updateSubscription(@NonNull String id, @NonNull SubscriptionUpdateRequestDTO request) {

        try {
            String response = BaseClient.putRequest(String.format(AsaasUtil.UPDATE_SUBSCRIPTION, id),
                    gson.toJson(request));
            return gson.fromJson(response, SubscriptionResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public DeleteResponseDTO deleteSubscription(@NonNull String id) {

        try {
            String response = BaseClient.deleteRequest(String.format(AsaasUtil.DELETE_SUBSCRIPTION, id));
            return gson.fromJson(response, DeleteResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PaymentsListResponseDTO paymentsListOfASubscription(@NonNull String id, StatusPayment status) {

        var query = status == null ? "" : "?status=" + status.name();

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.LIST_PAYMENTS_OF_A_SUBSCRIPTION, id),
                    query);
            return gson.fromJson(response, PaymentsListResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public String generateSubscriptionBooklet(@NonNull String id, @NonNull Integer month, @NonNull Integer year, String sort,
                                              String order) {

        var query = AsaasUtil.getParamsGenerateSubscriptionBooklet(month, year, sort, order);

        try {
            return BaseClient.getRequest(String.format(AsaasUtil.GENERATE_SUBSCRIPTION_BOOKLET, id), query);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public ConfigurationIssuingInvoicesResponseDTO createConfigurationForIssuingInvoice(@NonNull String id,
                                                                                        @NonNull ConfigurationIssuingInvoicesRequestDTO request) {

        try {
            String response =
                    BaseClient.postRequest(String.format(AsaasUtil.CREATE_CONFIGURATION_FOR_ISSUING_INVOICES, id),
                            gson.toJson(request));
            return gson.fromJson(response, ConfigurationIssuingInvoicesResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public ConfigurationIssuingInvoicesResponseDTO getConfigurationForIssuingInvoice(@NonNull String id) {

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.RETRIEVE_CONFIGURATION_FOR_ISSUING_INVOICES, id), null);
            return gson.fromJson(response, ConfigurationIssuingInvoicesResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public DeleteResponseDTO deleteConfigurationForIssuingInvoice(@NonNull String id) {

        try {
            String response = BaseClient.deleteRequest(String.format(AsaasUtil.DELETE_SUBSCRIPTION, id));
            return gson.fromJson(response, DeleteResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public ConfigurationIssuingInvoicesResponseDTO updateConfigurationForIssuingInvoice(@NonNull String id,
                                                                                        @NonNull ConfigurationUpdateIssuingInvoicesRequestDTO request) {

        try {
            String response = BaseClient.putRequest(String.format(AsaasUtil.UPDATE_CONFIGURATION_FOR_ISSUING_INVOICES
                    , id), gson.toJson(request));
            return gson.fromJson(response, ConfigurationIssuingInvoicesResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public InvoicesListResponseDTO invoicesForSubscriptionList(@NonNull String id, Integer offset, Integer limit,
                                                               String effectiveDateGe,
                                                               String effectiveDateLe, String externalReference,
                                                               StatusInvoice status, String customer) {

        var query = AsaasUtil.getParamsListInvoicesForSubscription(offset, limit, effectiveDateGe, effectiveDateLe,
                externalReference, status, customer);

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.LIST_INVOICES_FOR_SUBSCRIPTION, id), query);
            return gson.fromJson(response, InvoicesListResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }
}
