package com.asaas.docs.service.document;

import com.asaas.docs.dto.request.DocumentRequestDTO;
import com.asaas.docs.dto.response.DeleteResponseDTO;
import com.asaas.docs.dto.response.DocumentListResponseDTO;
import com.asaas.docs.dto.response.DocumentResponseDTO;
import lombok.NonNull;

import java.nio.file.Path;

public interface DocumentService {

    DocumentResponseDTO uploadDocumentPayment(@NonNull String id, @NonNull DocumentRequestDTO request, @NonNull Path path);

    DocumentListResponseDTO documentsListPayment(@NonNull String id);

    DocumentResponseDTO updateSettingsDocumentPayment(@NonNull String id, @NonNull String documentId, @NonNull DocumentRequestDTO request);

    DocumentResponseDTO retrieveDocumentPayment(@NonNull String id, @NonNull String documentId);

    DeleteResponseDTO deleteDocumentPayment(@NonNull String id, @NonNull String documentId);

}
