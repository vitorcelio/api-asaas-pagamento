package com.asaas.docs.service.pix;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.dto.request.PixTransactionRequestDTO;
import com.asaas.docs.dto.request.QrCodePixRequestDTO;
import com.asaas.docs.dto.response.PixTransactionListResponseDTO;
import com.asaas.docs.dto.response.PixTransactionResponseDTO;
import com.asaas.docs.dto.response.QrCodeDecodeResponseDTO;
import com.asaas.docs.service.pix.impl.TransactionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static com.asaas.docs.configuration.AsaasApiConfig.API_KEY_ASAAS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TransactionTest {

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        AsaasApiConfig.setApiKey(API_KEY_ASAAS);
    }

    @Test
    public void testPayQrCode_Success() {

        PixTransactionRequestDTO request = PixTransactionRequestDTO.builder()
                .qrCode(QrCodePixRequestDTO.builder()
                        .payload("00020126580014br.gov.bcb.pix01369fb205f6-d956-4bba-8a39-9aff3a0df9ee5204000053039865802BR5925Vitor Celio de Oliveira S6013Caxias do Sul62290525VITORCEL00000000540043ASA6304AE1D")
                        //changeValue(new BigDecimal("50.00"))
                        .build())
                .value(new BigDecimal("100.00"))
                .description("Testando pagar com pix")
                .scheduleDate("2024-11-11")
                .build();

        PixTransactionResponseDTO response = transactionService.payQrCode(request);
        assertEquals(PixTransactionResponseDTO.class, response.getClass());
        assertNotNull(response);

    }

    @Test
    public void testDecodeQrCodeForPayment_Success() {

        QrCodePixRequestDTO request = QrCodePixRequestDTO.builder()
                .payload("00020126580014br.gov.bcb.pix01369fb205f6-d956-4bba-8a39-9aff3a0df9ee5204000053039865802BR5925Vitor Celio de Oliveira S6013Caxias do Sul62290525VITORCEL00000000540043ASA6304AE1D")
                .build();

        QrCodeDecodeResponseDTO response = transactionService.decodeQrCodeForPayment(request);
        assertEquals(QrCodeDecodeResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals("00020126580014br.gov.bcb.pix01369fb205f6-d956-4bba-8a39-9aff3a0df9ee5204000053039865802BR5925Vitor Celio de Oliveira S6013Caxias do Sul62290525VITORCEL00000000540043ASA6304AE1D", response.getPayload());

    }

    @Test
    public void testGetPixTransaction_Success() {

        PixTransactionResponseDTO response = transactionService.getPixTransaction("b442eb7f-f0b1-46ef-bdb4-67336187ea0d");

        assertEquals(PixTransactionResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals("b442eb7f-f0b1-46ef-bdb4-67336187ea0d", response.getId());

    }

    @Test
    public void testTransactionsList_Success() {

        PixTransactionListResponseDTO response = transactionService.transactionsList(null, null, null, null, null);

        assertEquals(PixTransactionListResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertNotNull(response.getData());

    }

    @Test
    public void testCancelScheduledTransaction_Success() {

        PixTransactionResponseDTO response = transactionService.cancelScheduledTransaction("b442eb7f-f0b1-46ef-bdb4-67336187ea0d");

        assertEquals(PixTransactionResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals("b442eb7f-f0b1-46ef-bdb4-67336187ea0d", response.getId());

    }

}
