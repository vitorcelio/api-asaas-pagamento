package com.asaas.docs.service.customer.impl;

import com.asaas.docs.client.BaseClient;
import com.asaas.docs.dto.request.CustomerRequestDTO;
import com.asaas.docs.dto.response.CustomerListResponseDTO;
import com.asaas.docs.dto.response.CustomerResponseDTO;
import com.asaas.docs.dto.response.DeleteResponseDTO;
import com.asaas.docs.dto.response.NotificationsListResponseDTO;
import com.asaas.docs.exception.AsaasApiException;
import com.asaas.docs.service.customer.CustomerService;
import com.asaas.docs.util.AsaasUtil;
import com.google.gson.Gson;
import lombok.NonNull;

public class CustomerServiceImpl implements CustomerService {

    private final Gson gson = new Gson();

    @Override
    public CustomerResponseDTO createCustomer(@NonNull CustomerRequestDTO request) {

        try {
            String response = BaseClient.postRequest(AsaasUtil.CREATE_CUSTOMER, gson.toJson(request));
            return gson.fromJson(response, CustomerResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public CustomerListResponseDTO customerList(Integer offset, Integer limit, String name, String email,
                                                String cpfCnpj, String groupName, String externalReference) {

        var query = AsaasUtil.getParamsListCustomer(offset, limit, name, email, cpfCnpj, groupName, externalReference);

        try {
            String response = BaseClient.getRequest(AsaasUtil.LIST_CUSTOMERS, query);
            return gson.fromJson(response, CustomerListResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public CustomerResponseDTO getCustomer(@NonNull String id) {

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.GET_CUSTOMER, id), null);
            return gson.fromJson(response, CustomerResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public CustomerResponseDTO updateCustomer(@NonNull String id, @NonNull CustomerRequestDTO request) {

        try {
            String response = BaseClient.putRequest(String.format(AsaasUtil.UPDATE_CUSTOMER, id), gson.toJson(request));
            return gson.fromJson(response, CustomerResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public DeleteResponseDTO deleteCustomer(@NonNull String id) {

        try {
            String response = BaseClient.deleteRequest(String.format(AsaasUtil.DELETE_CUSTOMER, id));
            return gson.fromJson(response, DeleteResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public CustomerResponseDTO restoreCustomer(@NonNull String id) {

        try {
            String response = BaseClient.postRequest(String.format(AsaasUtil.RESTORE_CUSTOMER, id), null);
            return gson.fromJson(response, CustomerResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public NotificationsListResponseDTO notificationListCustomer(@NonNull String id) {

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.RETRIEVE_NOTIFICATIONS_CUSTOMER, id), null);
            return gson.fromJson(response, NotificationsListResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }
}
