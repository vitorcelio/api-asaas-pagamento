package com.asaas.docs.service.accountInfo.impl;

import com.asaas.docs.client.BaseClient;
import com.asaas.docs.dto.request.BusinessDataRequestDTO;
import com.asaas.docs.dto.request.CheckoutCustomizationRequestDTO;
import com.asaas.docs.dto.response.*;
import com.asaas.docs.exception.AsaasApiException;
import com.asaas.docs.service.accountInfo.AccountInfoService;
import com.asaas.docs.util.AsaasUtil;
import com.google.gson.Gson;
import lombok.NonNull;

import java.nio.file.Path;

public class AccountInfoServiceImpl implements AccountInfoService {

    private Gson gson = new Gson();

    @Override
    public BusinessDataResponseDTO getBusinessData() {

        try {
            String response = BaseClient.getRequest(AsaasUtil.GET_BUSINESS_DATA, null);
            return gson.fromJson(response, BusinessDataResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public BusinessDataResponseDTO updateBusinessData(@NonNull BusinessDataRequestDTO request) {

        try {
            String response = BaseClient.postRequest(AsaasUtil.UPDATE_BUSINESS_DATA, gson.toJson(request));
            return gson.fromJson(response, BusinessDataResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public CheckoutCustomizationResponseDTO checkoutCustomization(@NonNull CheckoutCustomizationRequestDTO request, Path path) {

        try {
            String response = BaseClient.postRequestMultipartFormData(AsaasUtil.PAYMENT_CHECKOUT_CONFIG, gson.toJson(request), path, "logoFile", CheckoutCustomizationRequestDTO.class);
            return gson.fromJson(response, CheckoutCustomizationResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public PersonalizationSettingsResponseDTO getPersonalizationSettings() {

        try {
            String response = BaseClient.getRequest(AsaasUtil.GET_PAYMENT_CHECKOUT_CONFIG, null);
            return gson.fromJson(response, PersonalizationSettingsResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public AsaasAccountNumberResponseDTO getAsaasAccountNumber() {

        try {
            String response = BaseClient.getRequest(AsaasUtil.GET_ASAAS_ACCOUNT_NUMBER, null);
            return gson.fromJson(response, AsaasAccountNumberResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public AccountFeesResponseDTO getAccountFee() {

        try {
            String response = BaseClient.getRequest(AsaasUtil.GET_ACCOUNT_FEES, null);
            return gson.fromJson(response, AccountFeesResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public CheckAccountRegistrationStatusResponseDTO checkAccountRegistrationStatus() {

        try {
            String response = BaseClient.getRequest(AsaasUtil.CHECK_ACCOUNT_REGISTRATION_STATUS, null);
            return gson.fromJson(response, CheckAccountRegistrationStatusResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public WalletIdListResponseDTO getWalletId() {

        try {
            String response = BaseClient.getRequest(AsaasUtil.GET_WALLET_ID, null);
            return gson.fromJson(response, WalletIdListResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public DeleteWhiteLabelResponseDTO deleteWhiteLabelSubAccount(@NonNull String removeReason) {

        var query = "?removeReason=" + removeReason;

        try {
            String response = BaseClient.deleteRequest(AsaasUtil.DELETE_WHITE_LABEL_SUB_ACCOUNT, query);
            return gson.fromJson(response, DeleteWhiteLabelResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }
}
