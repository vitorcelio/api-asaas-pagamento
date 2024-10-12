package com.asaas.docs.service.payment;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.dto.request.PaymentReceiptCashRequestDTO;
import com.asaas.docs.dto.request.PaymentRequestDTO;
import com.asaas.docs.dto.request.PaymentUpdateRequestDTO;
import com.asaas.docs.dto.response.PaymentDeleteResponseDTO;
import com.asaas.docs.dto.response.PaymentListSummaryResponseDTO;
import com.asaas.docs.dto.response.PaymentSummaryResponseDTO;
import com.asaas.docs.enums.BillingType;
import com.asaas.docs.service.payment.impl.PaymentSummaryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentSummaryTest {

    private static final String API_KEY_ASAAS = "";

    @InjectMocks
    private PaymentSummaryServiceImpl paymentSummaryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        AsaasApiConfig.setApiKey(API_KEY_ASAAS);
    }

    @Test
    public void testCreatePaymentSummary_Success() {
        PaymentRequestDTO request = PaymentRequestDTO.builder()
                .customer("cus_000005828409")
                .billingType(BillingType.BOLETO)
                .value(new BigDecimal("100.00"))
                .dueDate("2024-10-11")
                .description("Cobrança Teste Resumida")
                .daysAfterDueDateToRegistrationCancellation(3)
                .externalReference(UUID.randomUUID().toString())
                .build();

        PaymentSummaryResponseDTO response = paymentSummaryService.createSummaryPayment(request);
        assertEquals(PaymentSummaryResponseDTO.class, response.getClass());
        assertEquals(request.getCustomer(), response.getCustomerId());
    }

    @Test
    public void testSummaryPaymentList_Success() {
        PaymentListSummaryResponseDTO response = paymentSummaryService.summaryPaymentsList(null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null);

        assertEquals(PaymentListSummaryResponseDTO.class, response.getClass());
        assertEquals(ArrayList.class, response.getData().getClass());
        assertNotEquals(null, response);
        assertNotEquals(null, response.getData());
    }

    @Test
    public void testSummaryPayWithCreditCard_Success() {
        PaymentRequestDTO request = PaymentRequestDTO.builder()
                .customer("cus_000005828409")
                .billingType(BillingType.CREDIT_CARD)
                .value(new BigDecimal("120.00"))
                .dueDate("2024-10-11")
                .description("Cobrança Teste Cartão de Crédito")
//                .creditCard(CreditCardRequestDTO.builder()
//                        .holderName("John Doe")
//                        .number("1234567890123456")
//                        .expiryMonth("10")
//                        .expiryYear("2024")
//                        .ccv("123")
//                        .build())
//                .creditCardHolderInfo(CreditCardHolderInfoRequestDTO.builder()
//                        .name("John Doe")
//                        .email("john.doe@asaas.com")
//                        .cpfCnpj("12345678901")
//                        .addressNumber("123")
//                        .addressComplement("456")
//                        .phone("99988204161")
//                        .build())
                .build();

        PaymentSummaryResponseDTO response = paymentSummaryService.createSummaryPayment(request);
        assertEquals(PaymentSummaryResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
    }

    @Test
    public void testCaptureSummaryPaymentPreAuthorization_Success() {
        PaymentSummaryResponseDTO response = paymentSummaryService.captureSummaryPaymentPreAuthorization("pay_7uyrdplwc6gtr8su");

        assertEquals(PaymentSummaryResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals("pay_7uyrdplwc6gtr8su", response.getId());
    }

    @Test
    public void testGetSummaryPayment_Success() {
        PaymentSummaryResponseDTO response = paymentSummaryService.getSummaryPayment("pay_dhw5smski5bjk5nz");

        assertEquals(PaymentSummaryResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals("pay_dhw5smski5bjk5nz", response.getId());
    }

    @Test
    public void testUpdateSummaryPayment_Success() {

        PaymentUpdateRequestDTO request = PaymentUpdateRequestDTO.builder()
                .billingType(BillingType.PIX)
                .value(new BigDecimal("100.00"))
                .dueDate("2024-10-11")
                .description("Atualização do pagamento")
                .build();

        PaymentSummaryResponseDTO response = paymentSummaryService.updateSummaryPayment("pay_dm3esz45fo1tfj0i", request);
        assertEquals(PaymentSummaryResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals("pay_dm3esz45fo1tfj0i", response.getId());
        assertEquals(BillingType.PIX, response.getBillingType());

    }

    @Test
    public void testDeleteSummaryPayment_Success() {
        PaymentDeleteResponseDTO response = paymentSummaryService.deleteSummaryPayment("pay_dm3esz45fo1tfj0i");

        assertEquals(PaymentDeleteResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals("pay_dm3esz45fo1tfj0i", response.getId());
        assertTrue(response.isDeleted());
    }

    @Test
    public void testRestoreSummaryPayment_Success() {
        PaymentSummaryResponseDTO response = paymentSummaryService.restoreSummaryPayment("pay_dm3esz45fo1tfj0i");

        assertEquals(PaymentSummaryResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals("pay_dm3esz45fo1tfj0i", response.getId());
    }

    @Test
    public void testRefundSummaryPayment_Success() {
        PaymentSummaryResponseDTO response = paymentSummaryService.refundSummaryPayment("pay_dhw5smski5bjk5nz");

        assertEquals(PaymentSummaryResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals("pay_dhw5smski5bjk5nz", response.getId());
    }

    @Test
    public void testConfirmCashReceiptSummary_Success() {

        PaymentReceiptCashRequestDTO request = PaymentReceiptCashRequestDTO.builder()
                .paymentDate("2024-10-11")
                .value(new BigDecimal("50.00"))
                .build();

        PaymentSummaryResponseDTO response = paymentSummaryService.confirmCashReceiptSummary("pay_22il68y80uv9kaqs", request);
        assertEquals(PaymentSummaryResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals("pay_22il68y80uv9kaqs", response.getId());
    }

    @Test
    public void testUndoCashReceiptSummary_Success() {
        PaymentSummaryResponseDTO response = paymentSummaryService.undoCashReceiptSummary("pay_22il68y80uv9kaqs");

        assertEquals(PaymentSummaryResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals("pay_22il68y80uv9kaqs", response.getId());
    }
}
