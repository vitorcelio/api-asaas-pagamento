package com.asaas.docs.service.pix.impl;

import com.asaas.docs.client.BaseClient;
import com.asaas.docs.dto.response.RecurrenceItemResponseDTO;
import com.asaas.docs.dto.response.RecurrenceItemsListResponseDTO;
import com.asaas.docs.dto.response.RecurrenceListResponseDTO;
import com.asaas.docs.dto.response.RecurrenceResponseDTO;
import com.asaas.docs.enums.RecurrenceStatus;
import com.asaas.docs.exception.AsaasApiException;
import com.asaas.docs.service.pix.RecurrenceService;
import com.asaas.docs.util.AsaasUtil;
import com.google.gson.Gson;
import lombok.NonNull;

import java.math.BigDecimal;

public class RecurrenceServiceImpl implements RecurrenceService {

    private Gson gson = new Gson();

    @Override
    public RecurrenceListResponseDTO recurrenceList(Integer offset, Integer limit, RecurrenceStatus status, BigDecimal value, String searchText) {

        var query = AsaasUtil.getParamsListRecurrences(offset, limit, status, value, searchText);

        try {
            String response = BaseClient.getRequest(AsaasUtil.LIST_RECURRENCES, query);
            return gson.fromJson(response, RecurrenceListResponseDTO.class);
        } catch (AsaasApiException e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public RecurrenceResponseDTO getRecurrence(@NonNull String id) {

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.GET_RECURRENCE, id), null);
            return gson.fromJson(response, RecurrenceResponseDTO.class);
        } catch (AsaasApiException e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public RecurrenceResponseDTO cancelRecurrence(@NonNull String id) {

        try {
            String response = BaseClient.postRequest(String.format(AsaasUtil.CANCEL_RECURRENCE, id), null);
            return gson.fromJson(response, RecurrenceResponseDTO.class);
        } catch (AsaasApiException e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public RecurrenceItemsListResponseDTO recurrenceItemsList(@NonNull String id, Integer offset, Integer limit) {

        var query = AsaasUtil.getParamsListBase(offset, limit);

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.LIST_RECURRENCE_ITEMS, id), query);
            return gson.fromJson(response, RecurrenceItemsListResponseDTO.class);
        } catch (AsaasApiException e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public RecurrenceItemResponseDTO cancelRecurrenceItem(@NonNull String id) {

        try {
            String response = BaseClient.postRequest(String.format(AsaasUtil.CANCEL_RECURRENCE_ITEMS, id), null);
            return gson.fromJson(response, RecurrenceItemResponseDTO.class);
        } catch (AsaasApiException e) {
            throw new AsaasApiException(e);
        }

    }
}
