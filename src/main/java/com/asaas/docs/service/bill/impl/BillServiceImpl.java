package com.asaas.docs.service.bill.impl;

import com.asaas.docs.client.BaseClient;
import com.asaas.docs.dto.request.BillRequestDTO;
import com.asaas.docs.dto.request.SimulateBillRequestDTO;
import com.asaas.docs.dto.response.BillListResponseDTO;
import com.asaas.docs.dto.response.BillResponseDTO;
import com.asaas.docs.dto.response.SimulateBillResponseDTO;
import com.asaas.docs.exception.AsaasApiException;
import com.asaas.docs.service.bill.BillService;
import com.asaas.docs.util.AsaasUtil;
import com.google.gson.Gson;
import lombok.NonNull;

public class BillServiceImpl implements BillService {

    private Gson gson = new Gson();

    @Override
    public BillResponseDTO createBillPayment(@NonNull BillRequestDTO request) {

        try {
            String response = BaseClient.postRequest(AsaasUtil.CREATE_BILL_PAYMENT, gson.toJson(request));
            return gson.fromJson(response, BillResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public BillListResponseDTO billListPayments(Integer offset, Integer limit) {

        var query = AsaasUtil.getParamsListBase(offset, limit);

        try {
            String response = BaseClient.getRequest(AsaasUtil.LIST_BILL_PAYMENTS, query);
            return gson.fromJson(response, BillListResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public SimulateBillResponseDTO simulateBillPayment(@NonNull SimulateBillRequestDTO request) {

        try {
            String response = BaseClient.postRequest(AsaasUtil.SIMULATE_BILL_PAYMENT, gson.toJson(request));
            return gson.fromJson(response, SimulateBillResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public BillResponseDTO getBillPayment(@NonNull String id) {

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.GET_BILL_PAYMENT, id), null);
            return gson.fromJson(response, BillResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public BillResponseDTO cancelBillPayment(@NonNull String id) {

        try {
            String response = BaseClient.postRequest(String.format(AsaasUtil.CANCEL_BILL_PAYMENT, id), null);
            return gson.fromJson(response, BillResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

}
