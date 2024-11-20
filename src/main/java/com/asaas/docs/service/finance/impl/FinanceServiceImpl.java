package com.asaas.docs.service.finance.impl;

import com.asaas.docs.client.BaseClient;
import com.asaas.docs.dto.response.BalanceResponseDTO;
import com.asaas.docs.dto.response.SplitValuesResponseDTO;
import com.asaas.docs.dto.response.StatisticsResponseDTO;
import com.asaas.docs.enums.BillingType;
import com.asaas.docs.exception.AsaasApiException;
import com.asaas.docs.service.finance.FinanceService;
import com.asaas.docs.util.AsaasUtil;
import com.google.gson.Gson;

public class FinanceServiceImpl implements FinanceService {

    private Gson gson = new Gson();

    @Override
    public BalanceResponseDTO getBalance() {

        try {
            String response = BaseClient.getRequest(AsaasUtil.GET_BALANCE, null);
            return gson.fromJson(response, BalanceResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public StatisticsResponseDTO collectionsStatistics(String customer, BillingType billingType, Boolean anticipated,
                                                       String dateCreatedGe, String dateCreatedLe, String dueDateGe,
                                                       String dueDateLe, String estimatedCreditDateGe,
                                                       String estimatedCreditDateLe, String externalReference) {

        var query = AsaasUtil.getParamsListStatistics(customer, billingType, anticipated, dateCreatedGe,
                dateCreatedLe, dueDateGe, dueDateLe, estimatedCreditDateGe, estimatedCreditDateLe, externalReference);

        try {
            String response = BaseClient.getRequest(AsaasUtil.COLLECTIONS_STATISTICS, query);
            return gson.fromJson(response, StatisticsResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public SplitValuesResponseDTO getSplitValues() {

        try {
            String response = BaseClient.getRequest(AsaasUtil.GET_SPLIT_VALUES, null);
            return gson.fromJson(response, SplitValuesResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }
}
