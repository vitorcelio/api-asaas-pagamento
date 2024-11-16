package com.asaas.docs.service.extract;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.dto.response.ExtractListResponseDTO;
import com.asaas.docs.service.extract.impl.ExtractServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static com.asaas.docs.configuration.AsaasApiConfig.API_KEY_ASAAS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ExtractTest {

    @InjectMocks
    private ExtractServiceImpl extractService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        AsaasApiConfig.setApiKey(API_KEY_ASAAS);
    }

    @Test
    public void testGetExtractList_Success() {
        ExtractListResponseDTO response = extractService.getExtractList(null, null, null, null, null);

        assertEquals(ExtractListResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertNotNull(response.getData());
    }

}
