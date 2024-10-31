package com.asaas.docs.service.payment;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.dto.request.*;
import com.asaas.docs.dto.response.*;
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

import static com.asaas.docs.configuration.AsaasApiConfig.API_KEY_ASAAS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentTest {

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
                .billingType(BillingType.PIX)
                .value(new BigDecimal("100.00"))
                .dueDate("2024-10-14")
                .description("Cobrança Teste")
                //.daysAfterDueDateToRegistrationCancellation(3)
                .split(Arrays.asList(
                        SplitRequestDTO.builder()
                                .percentualValue(new BigDecimal("20.00"))
                                .walletId("63a73f6f-34a0-4d07-aab7-2c2a81a210a0")
                                .build()
                ))
                .externalReference(UUID.randomUUID().toString())
                .build();

        PaymentResponseDTO response = paymentService.createPayment(request);
        assertEquals(PaymentResponseDTO.class, response.getClass());
        assertEquals(request.getCustomer(), response.getCustomer());
    }

    @Test
    public void testPaymentList_Success() {
        PaymentsListResponseDTO response = paymentService.paymentsList(null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null);

        assertEquals(PaymentsListResponseDTO.class, response.getClass());
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
        DeleteResponseDTO response = paymentService.deletePayment("pay_4o023v5s2ugovmn0");

        assertEquals(DeleteResponseDTO.class, response.getClass());
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
                .paymentDate("2024-10-12")
                .value(new BigDecimal("100.00"))
                .build();

        PaymentResponseDTO response = paymentService.confirmCashReceipt("pay_4o023v5s2ugovmn0", request);
        assertEquals(PaymentResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals("pay_4o023v5s2ugovmn0", response.getId());
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

