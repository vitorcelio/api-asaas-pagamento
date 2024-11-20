package com.asaas.docs.service.subaccount.impl;

import com.asaas.docs.client.BaseClient;
import com.asaas.docs.dto.request.SubaccountRequestDTO;
import com.asaas.docs.dto.response.SubaccountListResponseDTO;
import com.asaas.docs.dto.response.SubaccountResponseDTO;
import com.asaas.docs.exception.AsaasApiException;
import com.asaas.docs.service.subaccount.SubaccountService;
import com.asaas.docs.util.AsaasUtil;
import com.google.gson.Gson;
import lombok.NonNull;

public class SubaccountServiceImpl implements SubaccountService {

    private Gson gson = new Gson();

    @Override
    public SubaccountResponseDTO createSubaccount(@NonNull SubaccountRequestDTO request) {

        try {
            String response = BaseClient.postRequest(AsaasUtil.CREATE_SUBACCOUNT, gson.toJson(request));
            return gson.fromJson(response, SubaccountResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public SubaccountListResponseDTO subaccountsList(Integer offset, Integer limit, String cpfCnpj, String email, String name, String walletId) {

        var query = AsaasUtil.getParamsListSubaccounts(offset, limit, cpfCnpj, email, name, walletId);

        try {
            String response = BaseClient.getRequest(AsaasUtil.LIST_SUBACCOUNT, query);
            return gson.fromJson(response, SubaccountListResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public SubaccountResponseDTO getSubaccount(@NonNull String id) {

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.GET_SUBACCOUNT, id), null);
            return gson.fromJson(response, SubaccountResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

}
