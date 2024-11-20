package com.asaas.docs.service.document;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.dto.request.DocumentRequestDTO;
import com.asaas.docs.dto.response.DeleteResponseDTO;
import com.asaas.docs.dto.response.DocumentListResponseDTO;
import com.asaas.docs.dto.response.DocumentResponseDTO;
import com.asaas.docs.enums.DocumentType;
import com.asaas.docs.service.document.impl.DocumentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.nio.file.Path;

import static com.asaas.docs.configuration.AsaasApiConfig.API_KEY_ASAAS;
import static org.junit.jupiter.api.Assertions.*;

public class DocumentTest {

    @InjectMocks
    private DocumentServiceImpl documentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        AsaasApiConfig.setApiKey(API_KEY_ASAAS);
    }

    @Test
    public void testUploadDocumentPayment_Success() {

        File file = new File("C:/Users/celio/Pictures/capa-pc3.png");

        Path path = file.toPath();

        DocumentRequestDTO request = DocumentRequestDTO.builder()
                .availableAfterPayment(false)
                .type(DocumentType.DOCUMENT)
                .build();

        DocumentResponseDTO response = documentService.uploadDocumentPayment("pay_30t9s7gsksltsvih", request, path.toAbsolutePath());
        assertEquals(DocumentResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals(DocumentType.DOCUMENT, response.getType());
        assertNotEquals(null, response.getFile());

    }

    @Test
    public void testDocumentsListPayment_Success() {
        DocumentListResponseDTO response = documentService.documentsListPayment("pay_30t9s7gsksltsvih");

        assertEquals(DocumentListResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertNotEquals(null, response.getData());
    }

    @Test
    public void testUpdateSettingsDocumentPayment_Success() {

        DocumentRequestDTO request = DocumentRequestDTO.builder()
                .availableAfterPayment(false)
                .type(DocumentType.CONTRACT)
                .build();

        DocumentResponseDTO response = documentService.updateSettingsDocumentPayment("pay_30t9s7gsksltsvih", "235e6606-f5fe-4109-8fd0-1b09b02a273e", request);
        assertEquals(DocumentResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals(DocumentType.CONTRACT, response.getType());
        assertNotEquals(null, response.getFile());
    }

    @Test
    public void testRetrieveDocumentPayment_Success() {
        DocumentResponseDTO response = documentService.retrieveDocumentPayment("pay_30t9s7gsksltsvih", "235e6606-f5fe-4109-8fd0-1b09b02a273e");

        assertEquals(DocumentResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals(DocumentType.CONTRACT, response.getType());
        assertNotEquals(null, response.getFile());
    }

    @Test
    public void testDeleteDocumentPayment_Success() {
        DeleteResponseDTO response = documentService.deleteDocumentPayment("pay_30t9s7gsksltsvih", "235e6606-f5fe-4109-8fd0-1b09b02a273e");

        assertEquals(DeleteResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertTrue(response.isDeleted());
    }

}
