package com.asaas.docs.service.transfer;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.dto.request.*;
import com.asaas.docs.dto.response.TransferListResponseDTO;
import com.asaas.docs.dto.response.TransferResponseDTO;
import com.asaas.docs.enums.AddressPixKeyType;
import com.asaas.docs.enums.RecurrenceFrequency;
import com.asaas.docs.enums.TransferStatus;
import com.asaas.docs.enums.TransferType;
import com.asaas.docs.service.transfer.impl.TransferServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static com.asaas.docs.configuration.AsaasApiConfig.API_KEY_ASAAS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TransferTest {

    @InjectMocks
    private TransferServiceImpl transferService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        AsaasApiConfig.setApiKey(API_KEY_ASAAS);
    }

    @Test
    public void testTransferAnotherInstitutionOrPix_Success() {

        TransferRequestDTO request = TransferRequestDTO.builder()
                .value(new BigDecimal("20"))
                .pixAddressKey("b057e070-0a05-42ca-a406-02826c15ce49")
                .pixAddressKeyType(AddressPixKeyType.EVP)
                .scheduleDate("2024-11-17")
//                .bankAccount(BankAccountRequestDTO.builder()
//                        .ownerName("Vítor Célio")
//                        .bank(new BankRequestDTO("461"))
//                        .cpfCnpj("429.769.680-04")
//                        .agency("0001")
//                        .account("107066")
//                        .accountDigit("4")
//                        .build())
//                .recurring(RecurrenceRequestDTO.builder()
//                        .frequency(RecurrenceFrequency.WEEKLY)
//                        .quantity(3)
//                        .build())
                .build();

        TransferResponseDTO response = transferService.transferAnotherInstitutionOrPix(request);
        assertEquals(TransferResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals(TransferType.PIX, response.getOperationType());

    }

    @Test
    public void testTransferList_Success() {

        TransferListResponseDTO response = transferService.transferList(null, null, null, null, null);

        assertNotNull(response);
        assertEquals(TransferListResponseDTO.class, response.getClass());
        assertNotNull(response.getData());

    }

    @Test
    public void testTransferAsaasAccount_Success() {

        TransferAsaasAccountRequestDTO request = TransferAsaasAccountRequestDTO.builder()
                .value(new BigDecimal("100"))
                .walletId("63a73f6f-34a0-4d07-aab7-2c2a81a210a0")
                .build();

        TransferResponseDTO response = transferService.transferAsaasAccount(request);
        assertEquals(TransferResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals("63a73f6f-34a0-4d07-aab7-2c2a81a210a0", response.getWalletId());

    }

    @Test
    public void testGetTransfer_Success() {

        TransferResponseDTO response = transferService.getTransfer("e1167b29-c085-4db2-a3d6-9e573cbfe38a");

        assertEquals(TransferResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals(TransferType.INTERNAL, response.getOperationType());
        assertEquals("e1167b29-c085-4db2-a3d6-9e573cbfe38a", response.getId());
        assertEquals("63a73f6f-34a0-4d07-aab7-2c2a81a210a0", response.getWalletId());

    }

    @Test
    public void testCancelTransfer_Success() {

        TransferResponseDTO response = transferService.cancelTransfer("e3c172a2-b4cd-4fdc-9f58-f6a1f12d21a0");

        assertEquals(TransferResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals(TransferStatus.CANCELLED, response.getStatus());

    }

}
