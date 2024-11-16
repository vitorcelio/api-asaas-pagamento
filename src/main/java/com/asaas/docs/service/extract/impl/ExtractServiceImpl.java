package com.asaas.docs.service.extract.impl;

import com.asaas.docs.client.BaseClient;
import com.asaas.docs.dto.response.ExtractListResponseDTO;
import com.asaas.docs.exception.AsaasApiException;
import com.asaas.docs.service.extract.ExtractService;
import com.asaas.docs.util.AsaasUtil;
import com.google.gson.Gson;

public class ExtractServiceImpl implements ExtractService {

    private Gson gson = new Gson();

    @Override
    public ExtractListResponseDTO getExtractList(Integer offset, Integer limit, String startDate, String finishDate, String order) {

        var query = AsaasUtil.getParamsListExtract(offset, limit, startDate, finishDate, order);

        try {
            String response = BaseClient.getRequest(AsaasUtil.GET_EXTRACT, query);
            return gson.fromJson(response, ExtractListResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }
}
