package com.asaas.docs.service.installment;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.dto.request.InstallmentRequestDTO;
import com.asaas.docs.dto.request.InstallmentSplitsRequestDTO;
import com.asaas.docs.dto.request.SplitRequestDTO;
import com.asaas.docs.dto.response.*;
import com.asaas.docs.enums.BillingType;
import com.asaas.docs.service.installments.impl.InstallmentsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InstallmentTest {

    @InjectMocks
    private InstallmentsServiceImpl installmentsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        AsaasApiConfig.setApiKey(AsaasApiConfig.API_KEY_ASAAS);
    }

    @Test
    public void testCreateInstallment_Success() {

        InstallmentRequestDTO request = InstallmentRequestDTO.builder()
                .installmentCount(3)
                .customer("cus_000006287494")
                .value(new BigDecimal("60.00"))
                .billingType(BillingType.CREDIT_CARD)
                .creditCardToken("da01831b-89c6-420d-bd6f-f74bdb00664c")
                .dueDate("2024-10-21")
                .description("Testando parcelamento 1")
                .paymentExternalReference(UUID.randomUUID().toString())
                .build();

        InstallmentResponseDTO response = installmentsService.createInstallment(request);
        assertNotNull(response);
        assertEquals(3, response.getInstallmentCount());
        assertEquals("cus_000006287494", response.getCustomer());
        assertEquals(BillingType.CREDIT_CARD, response.getBillingType());
        assertEquals("Testando parcelamento 1", response.getDescription());
    }

    @Test
    public void testInstallmentList_Success() {
        InstallmentListResponseDTO response = installmentsService.installmentList(null, null);

        assertNotNull(response);
        assertEquals(InstallmentListResponseDTO.class, response.getClass());
        assertNotNull(response.getData());
    }

    @Test
    public void testGetInstallment_Success() {
        InstallmentResponseDTO response = installmentsService.getInstallment("01642598-7624-4d30-8e87-2cba263d3001");

        assertNotNull(response);
        assertEquals(InstallmentResponseDTO.class, response.getClass());
        assertEquals("01642598-7624-4d30-8e87-2cba263d3001", response.getId());
    }

    @Test
    public void testDeleteInstallment_Success() {
        DeleteResponseDTO response = installmentsService.deleteInstallment("01642598-7624-4d30-8e87-2cba263d3001");

        assertEquals(DeleteResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertTrue(response.isDeleted());
    }

    @Test
    public void testPaymentListOfAInstallment_Success() {
        PaymentsListResponseDTO response = installmentsService.paymentsListOfAInstallment("8e19dd03-0201-4bdf-b2ca-2a7fa0ef252e", null);

        assertNotNull(response);
        assertEquals(PaymentsListResponseDTO.class, response.getClass());
        assertNotNull(response.getData());
    }

    @Test
    public void testGenerateInstallmentBooklet_Success() {
        String response = installmentsService.generateInstallmentBooklet("f79d572c-d6f3-4f51-9f10-7a98940a33df", null, null);

        assertNotNull(response);
    }

    @Test
    public void testRefundInstallment_Success() {
        InstallmentResponseDTO response = installmentsService.refundInstallment("f8cc8062-7354-47f7-bc2a-8a18f5486b9e");

        assertNotNull(response);
        assertEquals(InstallmentResponseDTO.class, response.getClass());
        assertEquals("f8cc8062-7354-47f7-bc2a-8a18f5486b9e", response.getId());
    }

    @Test
    public void testUpdateInstallmentSplits_Success() {

        InstallmentSplitsRequestDTO request = InstallmentSplitsRequestDTO.builder()
                .splits(Arrays.asList(
                        SplitRequestDTO.builder()
                                .walletId("63a73f6f-34a0-4d07-aab7-2c2a81a210a0")
                                .fixedValue(new BigDecimal("40.00"))
                                .installmentNumber(1)
                                .build()
                ))
                .build();

        InstallmentSplitsResponseDTO response = installmentsService.updateInstallmentSplits("f8cc8062-7354-47f7-bc2a-8a18f5486b9e", request);
        assertNotNull(response);
        assertEquals(InstallmentSplitsResponseDTO.class, response.getClass());
        assertNotNull(response.getSplits());
    }

}
