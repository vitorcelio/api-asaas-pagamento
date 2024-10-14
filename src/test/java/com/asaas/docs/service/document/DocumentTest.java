package com.asaas.docs.service.document;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.dto.request.UploadDocumentRequestDTO;
import com.asaas.docs.dto.response.DocumentResponseDTO;
import com.asaas.docs.enums.DocumentType;
import com.asaas.docs.service.document.impl.DocumentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.io.File;

import static com.asaas.docs.configuration.AsaasApiConfig.API_KEY_ASAAS;

public class DocumentTest {

    @InjectMocks
    private DocumentServiceImpl documentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        AsaasApiConfig.setApiKey(API_KEY_ASAAS);
    }

    @Test
    public void testUploadDocumentPayment_Failed() {

        File file = new File("C:/Users/celio/Imagens/capa-pc.png");

        UploadDocumentRequestDTO request = UploadDocumentRequestDTO.builder()
                .availableAfterPayment(false)
                .type(DocumentType.DOCUMENT)
                .file(file)
                .build();

        DocumentResponseDTO response = documentService.uploadDocumentPayment("pay_30t9s7gsksltsvih", request);
        Assertions.assertEquals(DocumentResponseDTO.class, response.getClass());
        Assertions.assertNotEquals(null, response);
        Assertions.assertEquals(DocumentType.DOCUMENT, response.getType());
        Assertions.assertNotEquals(null, response.getFile());

    }

}
