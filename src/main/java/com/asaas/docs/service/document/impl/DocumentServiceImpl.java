package com.asaas.docs.service.document.impl;

import com.asaas.docs.client.BaseClient;
import com.asaas.docs.dto.request.DocumentRequestDTO;
import com.asaas.docs.dto.response.DeleteResponseDTO;
import com.asaas.docs.dto.response.DocumentListResponseDTO;
import com.asaas.docs.dto.response.DocumentResponseDTO;
import com.asaas.docs.exception.AsaasApiException;
import com.asaas.docs.service.document.DocumentService;
import com.asaas.docs.util.AsaasUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.NonNull;

import java.nio.file.Path;

public class DocumentServiceImpl implements DocumentService {

    public static Gson gson = new Gson();

    @Override
    public DocumentResponseDTO uploadDocumentPayment(@NonNull String id, @NonNull DocumentRequestDTO request, @NonNull Path path) {

        try {
            gson = new GsonBuilder().enableComplexMapKeySerialization().create();
            String response = BaseClient.postRequestMultipartFormData(String.format(AsaasUtil.UPLOAD_DOCUMENT_PAYMENT, id), gson.toJson(request), path, "file", DocumentRequestDTO.class);
            return gson.fromJson(response, DocumentResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public DocumentListResponseDTO documentsListPayment(@NonNull String id) {

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.LIST_DOCUMENTS_PAYMENT, id), null);
            return gson.fromJson(response, DocumentListResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public DocumentResponseDTO updateSettingsDocumentPayment(@NonNull String id, @NonNull String documentId, @NonNull DocumentRequestDTO request) {

        try {
            String response = BaseClient.putRequest(String.format(AsaasUtil.UPDATE_SETTINGS_DOCUMENT_PAYMENT, id, documentId), gson.toJson(request));
            return gson.fromJson(response, DocumentResponseDTO.class);
        } catch (Exception e) {
            throw new AsaasApiException(e);
        }

    }

    @Override
    public DocumentResponseDTO retrieveDocumentPayment(@NonNull String id, @NonNull String documentId) {

        try {
            String response = BaseClient.getRequest(String.format(AsaasUtil.RETRIEVE_DOCUMENT_PAYMENT, id, documentId), null);
            return gson.fromJson(response, DocumentResponseDTO.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public DeleteResponseDTO deleteDocumentPayment(@NonNull String id, @NonNull String documentId) {

        try {
            String response = BaseClient.deleteRequest(String.format(AsaasUtil.DELETE_DOCUMENT_PAYMENT, id, documentId));
            return gson.fromJson(response, DeleteResponseDTO.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
