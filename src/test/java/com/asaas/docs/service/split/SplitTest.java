package com.asaas.docs.service.split;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.dto.response.SplitListResponseDTO;
import com.asaas.docs.dto.response.SplitResponseDTO;
import com.asaas.docs.service.split.impl.SplitServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static com.asaas.docs.configuration.AsaasApiConfig.API_KEY_ASAAS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SplitTest {

    @InjectMocks
    private SplitServiceImpl splitService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        AsaasApiConfig.setApiKey(API_KEY_ASAAS);
    }

    @Test
    public void testGetSplitPaid_Success() {
        SplitResponseDTO response = splitService.getSplitPaid("018315af-088c-4d6d-a6e1-224d9602b397");

        assertEquals(SplitResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals("018315af-088c-4d6d-a6e1-224d9602b397", response.getId());
    }

    @Test
    public void testSplitsPaidList_Success() {
        SplitListResponseDTO response = splitService.splitsPaidList(null, null, null, null, null, null, null, null);

        assertEquals(SplitListResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertNotEquals(null, response.getData());
    }

    @Test
    public void testGetSplitReceived_Success() {
        SplitResponseDTO response = splitService.getSplitReceived("018315af-088c-4d6d-a6e1-224d9602b397");

        assertEquals(SplitResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals("018315af-088c-4d6d-a6e1-224d9602b397", response.getId());
    }

    @Test
    public void testSplitsReceivedList_Success() {
        SplitListResponseDTO response = splitService.splitsReceivedList(null, null, null, null, null, null, null, null);

        assertEquals(SplitListResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertNotEquals(null, response.getData());
    }

}
