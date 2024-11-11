package com.asaas.docs.service.pix;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.dto.request.PixRequestDTO;
import com.asaas.docs.dto.response.DeleteResponseDTO;
import com.asaas.docs.dto.response.PixListResponseDTO;
import com.asaas.docs.dto.response.PixResponseDTO;
import com.asaas.docs.dto.response.QrCodeResponseDTO;
import com.asaas.docs.enums.PixType;
import com.asaas.docs.enums.PixKeyStatus;
import com.asaas.docs.service.pix.impl.PixServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static com.asaas.docs.configuration.AsaasApiConfig.API_KEY_ASAAS;
import static org.junit.jupiter.api.Assertions.*;

public class PixTest {

    @InjectMocks
    private PixServiceImpl pixService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        AsaasApiConfig.setApiKey(API_KEY_ASAAS);
    }

    @Test
    public void testCreateKey_Success() {

        PixRequestDTO request = PixRequestDTO.builder()
                .type(PixType.EVP)
                .build();

        PixResponseDTO response = pixService.createKey(request);
        assertEquals(PixResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals(PixType.EVP, response.getType());
    }

    @Test
    public void testKeysList_Success() {

        PixListResponseDTO response = pixService.keysList(null, null, null, null);

        assertEquals(PixListResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertNotNull(response.getData());

    }

    @Test
    public void testGetKey_Success() {

        PixResponseDTO response = pixService.getKey("74ec32ed-0fb5-454a-9d48-564c71f88f27");

        assertEquals(PixResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals(PixType.EVP, response.getType());
        assertEquals("74ec32ed-0fb5-454a-9d48-564c71f88f27", response.getId());

    }

    @Test
    public void testDeleteKey_Success() {

        PixResponseDTO response = pixService.deleteKey("4eadee5c-e703-4686-bb9a-6a6f3295be7c");

        assertEquals(PixResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals(PixKeyStatus.AWAITING_DELETION, response.getStatus());
        assertEquals("4eadee5c-e703-4686-bb9a-6a6f3295be7c", response.getId());

    }

    @Test
    public void testCreateStaticQrCode_Success() {

        QrCodeResponseDTO response = pixService.createStaticQrCode(null);

        assertEquals(QrCodeResponseDTO.class, response.getClass());
        assertNotNull(response);

    }

    @Test
    public void testDeleteStaticQrCode_Success() {

        DeleteResponseDTO response = pixService.deleteStaticQrCode("VITORCEL00000000539721ASA");

        assertEquals(DeleteResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertTrue(response.isDeleted());

    }

}
