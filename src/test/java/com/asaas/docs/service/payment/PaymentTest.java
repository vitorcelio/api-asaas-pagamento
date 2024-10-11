package com.asaas.docs.service.payment;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.dto.request.CreditCardHolderInfoRequestDTO;
import com.asaas.docs.dto.request.CreditCardRequestDTO;
import com.asaas.docs.dto.request.PaymentReceiptCashRequestDTO;
import com.asaas.docs.dto.request.PaymentRefundRequestDTO;
import com.asaas.docs.dto.request.PaymentRequestDTO;
import com.asaas.docs.dto.request.PaymentUpdateRequestDTO;
import com.asaas.docs.dto.request.SalesSimulationRequestDTO;
import com.asaas.docs.dto.response.BankSlipFeeResponseDTO;
import com.asaas.docs.dto.response.BankSlipResponseDTO;
import com.asaas.docs.dto.response.ChargebackResponseDTO;
import com.asaas.docs.dto.response.CreditCardFeeResponseDTO;
import com.asaas.docs.dto.response.CreditCardResponseDTO;
import com.asaas.docs.dto.response.PaymentBillingInfoResponseDTO;
import com.asaas.docs.dto.response.PaymentDeleteResponseDTO;
import com.asaas.docs.dto.response.PaymentListResponseDTO;
import com.asaas.docs.dto.response.PaymentResponseDTO;
import com.asaas.docs.dto.response.PaymentStatusResponseDTO;
import com.asaas.docs.dto.response.PaymentViewingInfoResponseDTO;
import com.asaas.docs.dto.response.PixFeeResponseDTO;
import com.asaas.docs.dto.response.PixResponseDTO;
import com.asaas.docs.dto.response.RecoveringPaymentLimitsResponseDTO;
import com.asaas.docs.dto.response.SalesSimulationResponseDTO;
import com.asaas.docs.enums.BillingType;
import com.asaas.docs.enums.StatusPayment;
import com.asaas.docs.service.payment.impl.PaymentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {

    private static final String API_KEY_ASAAS = "";

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        AsaasApiConfig.setApiKey(API_KEY_ASAAS);
    }

    @Test
    public void testCreatePayment_Success() {
        PaymentRequestDTO request = PaymentRequestDTO.builder()
                .customer("cus_000005828409")
                .billingType(BillingType.BOLETO)
                .value(new BigDecimal("100.00"))
                .dueDate("2024-10-08")
                .description("Cobrança Teste")
                .daysAfterDueDateToRegistrationCancellation(3)
                .externalReference(UUID.randomUUID().toString())
                .build();

        PaymentResponseDTO response = paymentService.createPayment(request);
        assertEquals(PaymentResponseDTO.class, response.getClass());
        assertEquals(request.getCustomer(), response.getCustomer());
    }

    @Test
    public void testPaymentList_Success() {
        PaymentListResponseDTO response = paymentService.paymentsList(null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null);

        assertEquals(PaymentListResponseDTO.class, response.getClass());
        assertEquals(ArrayList.class, response.getData().getClass());
    }

    @Test
    public void testCreatePaymentCreditCard_Success() {
        PaymentRequestDTO request = PaymentRequestDTO.builder()
                .customer("cus_000005828409")
                .billingType(BillingType.CREDIT_CARD)
                .value(new BigDecimal("120.00"))
                .dueDate("2024-10-08")
                .description("Cobrança Teste Cartão de Crédito")
                .externalReference(UUID.randomUUID().toString())
                //.installmentCount(3)
                .totalValue(new BigDecimal("120.00"))
                .build();

        PaymentResponseDTO response = paymentService.createPayment(request);
        assertEquals(PaymentResponseDTO.class, response.getClass());
        assertEquals(request.getCustomer(), response.getCustomer());
    }

    @Test
    public void testCapturePaymentPreAuthorization_Failed() {
        PaymentResponseDTO response = paymentService.capturePaymentPreAuthorization("pay_7uyrdplwc6gtr8su");

        assertEquals(PaymentResponseDTO.class, response.getClass());
        assertEquals("pay_7uyrdplwc6gtr8su", response.getId());
    }

    @Test
    public void testPayWithCreditCard_Success() {

        PaymentRequestDTO request = PaymentRequestDTO.builder()
                .creditCard(CreditCardRequestDTO.builder()
                        .holderName("John Doe")
                        .number("1234567890123456")
                        .expiryMonth("10")
                        .expiryYear("2024")
                        .ccv("123")
                        .build())
                .creditCardHolderInfo(CreditCardHolderInfoRequestDTO.builder()
                        .name("John Doe")
                        .email("john.doe@asaas.com")
                        .cpfCnpj("12345678901")
                        .addressNumber("123")
                        .addressComplement("456")
                        .phone("99988204161")
                        .build())
                .build();

        PaymentResponseDTO response = paymentService.payWithCreditCard("pay_7uyrdplwc6gtr8su", request);
        assertEquals(PaymentResponseDTO.class, response.getClass());
        assertEquals("pay_7uyrdplwc6gtr8su", response.getId());
    }

    @Test
    public void testRetrievePaymentBillingInfoCreditCard_Success() {
        PaymentBillingInfoResponseDTO response = paymentService.retrievePaymentBillingInfo("pay_7uyrdplwc6gtr8su");

        assertEquals(PaymentBillingInfoResponseDTO.class, response.getClass());
        assertEquals(CreditCardResponseDTO.class, response.getCreditCard().getClass());
        assertNotEquals(null, response);
        assertNotEquals(null, response.getCreditCard());
    }

    @Test
    public void testRetrievePaymentBillingInfoBankSlip_Success() {
        PaymentBillingInfoResponseDTO response = paymentService.retrievePaymentBillingInfo("pay_i63qmal7yf3f47qq");

        assertEquals(PaymentBillingInfoResponseDTO.class, response.getClass());
        assertEquals(BankSlipResponseDTO.class, response.getBankSlip().getClass());
        assertNotEquals(null, response);
        assertNotEquals(null, response.getBankSlip());
    }

    @Test
    public void testRetrievePaymentBillingInfoPix_Success() {
        PaymentBillingInfoResponseDTO response = paymentService.retrievePaymentBillingInfo("pay_4z074yvxh6r71tr3");

        assertEquals(PaymentBillingInfoResponseDTO.class, response.getClass());
        assertEquals(PixResponseDTO.class, response.getPix().getClass());
        assertNotEquals(null, response);
        assertNotEquals(null, response.getPix());
    }

    @Test
    public void testPaymentViewingInfo_Success() {
        PaymentViewingInfoResponseDTO response = paymentService.paymentViewingInfo("pay_7uyrdplwc6gtr8su");

        assertEquals(PaymentViewingInfoResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
    }

    @Test
    public void testDeletePayment_Success() {
        PaymentDeleteResponseDTO response = paymentService.deletePayment("pay_4o023v5s2ugovmn0");

        assertEquals(PaymentDeleteResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals("pay_4o023v5s2ugovmn0", response.getId());
        assertTrue(response.isDeleted());
    }

    @Test
    public void testGetPayment_Success() {
        PaymentResponseDTO response = paymentService.getPayment("pay_7uyrdplwc6gtr8su");

        assertEquals(PaymentResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals("pay_7uyrdplwc6gtr8su", response.getId());
    }

    @Test
    public void testUpdatePayment_Success() {

        PaymentUpdateRequestDTO request = PaymentUpdateRequestDTO.builder()
                .billingType(BillingType.PIX)
                .value(new BigDecimal("100.00"))
                .dueDate("2024-10-09")
                .description("Atualização do pagamento")
                .build();

        PaymentResponseDTO response = paymentService.updatePayment("pay_i63qmal7yf3f47qq", request);
        assertEquals(PaymentResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals("pay_i63qmal7yf3f47qq", response.getId());
        assertEquals(BillingType.PIX, response.getBillingType());
    }

    @Test
    public void testRestorePayment_Success() {
        PaymentResponseDTO response = paymentService.restorePayment("pay_4o023v5s2ugovmn0");

        assertEquals(PaymentResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals("pay_4o023v5s2ugovmn0", response.getId());
    }

    @Test
    public void testRetrievePaymentStatus_Success() {
        PaymentStatusResponseDTO response = paymentService.retrievePaymentStatus("pay_4o023v5s2ugovmn0");

        assertEquals(PaymentStatusResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals(StatusPayment.PENDING, response.getStatus());
    }

    @Test
    public void testRefundPayment_Success() {

        PaymentRefundRequestDTO request = PaymentRefundRequestDTO.builder()
                //.value(new BigDecimal("25.00"))
                .description("Valor descontado do CUPOM")
                .build();

        PaymentResponseDTO response = paymentService.refundPayment("pay_kvmmpqi88rdj8d5c", request);
        assertEquals(PaymentResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals("pay_kvmmpqi88rdj8d5c", response.getId());
    }

    @Test
    public void testGetDigitableBillLines_Success() {
        BankSlipResponseDTO response = paymentService.getDigitableBillLines("pay_96ohwncugd20iivb");

        assertEquals(BankSlipResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
    }

    @Test
    public void testGetQrCodePix_Success() {
        PixResponseDTO response = paymentService.getQrCodePix("pay_i63qmal7yf3f47qq");

        assertEquals(PixResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
    }

    @Test
    public void testConfirmCashReceipt_Success() {

        PaymentReceiptCashRequestDTO request = PaymentReceiptCashRequestDTO.builder()
                .paymentDate("2024-10-08")
                .value(new BigDecimal("50.00"))
                .build();

        PaymentResponseDTO response = paymentService.confirmCashReceipt("pay_96ohwncugd20iivb", request);
        assertEquals(PaymentResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals("pay_96ohwncugd20iivb", response.getId());
    }

    @Test
    public void testUndoCashReceipt_Success() {
        PaymentResponseDTO response = paymentService.undoCashReceipt("pay_96ohwncugd20iivb");

        assertEquals(PaymentResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals("pay_96ohwncugd20iivb", response.getId());

    }

    @Test
    public void testSalesSimulation_Success() {

        SalesSimulationRequestDTO request = SalesSimulationRequestDTO.builder()
                .value(new BigDecimal("1500.00"))
                .installmentCount(5)
                .billingTypes(Arrays.asList("CREDIT_CARD", "BOLETO", "PIX"))
                .build();

        SalesSimulationResponseDTO response = paymentService.salesSimulation(request);
        assertEquals(SalesSimulationResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals(CreditCardFeeResponseDTO.class, response.getCreditCard().getClass());
        assertNotEquals(null, response.getCreditCard());
        assertEquals(BankSlipFeeResponseDTO.class, response.getBankSlip().getClass());
        assertNotEquals(null, response.getBankSlip());
        assertEquals(PixFeeResponseDTO.class, response.getPix().getClass());
        assertNotEquals(null, response.getPix());
    }

    @Test
    public void testRecoveringPaymentLimits_Success() {
        RecoveringPaymentLimitsResponseDTO response = paymentService.recoveringPaymentLimits();

        assertEquals(RecoveringPaymentLimitsResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
    }

    @Test
    public void testChargeback_Success() {
        ChargebackResponseDTO response = paymentService.getChargeback("pay_96ohwncugd20iivb");

        assertEquals(ChargebackResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
    }
}

