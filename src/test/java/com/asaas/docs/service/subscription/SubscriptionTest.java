package com.asaas.docs.service.subscription;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.dto.request.*;
import com.asaas.docs.dto.response.*;
import com.asaas.docs.enums.BillingType;
import com.asaas.docs.enums.CycleType;
import com.asaas.docs.enums.InvoiceCreationPeriod;
import com.asaas.docs.enums.StatusSubscription;
import com.asaas.docs.service.subscription.impl.SubscriptionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static com.asaas.docs.configuration.AsaasApiConfig.API_KEY_ASAAS;
import static org.junit.jupiter.api.Assertions.*;

public class SubscriptionTest {

    @InjectMocks
    private SubscriptionServiceImpl subscriptionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        AsaasApiConfig.setApiKey(API_KEY_ASAAS);
    }

    @Test
    public void testCreateSubscription_Success() {

        SubscriptionRequestDTO request = SubscriptionRequestDTO.builder()
                .customer("cus_000006287494")
                .billingType(BillingType.BOLETO)
                //.maxPayments(3)
                .value(new BigDecimal("380.00"))
                .cycle(CycleType.QUARTERLY)
                .description("Testando as assinaturas")
                .build();

        SubscriptionResponseDTO response = subscriptionService.createSubscription(request);
        assertEquals(SubscriptionResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals("cus_000006287494", response.getCustomer());
        assertEquals(BillingType.BOLETO, response.getBillingType());
        assertEquals(CycleType.QUARTERLY, response.getCycle());
        assertEquals("Testando as assinaturas", response.getDescription());

    }

    @Test
    public void testSubscriptionList_Success() {
        SubscriptionsListResponseDTO response = subscriptionService.subscriptionsList(null, null,
                null, null, null, null, null,
                null, null, null, null);

        assertEquals(SubscriptionsListResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertNotNull(response.getData());
    }

    @Test
    public void testGetSubscription_Success() {
        SubscriptionResponseDTO response = subscriptionService.getSubscription("sub_fmwjzh4uujc5jeid");

        assertEquals(SubscriptionResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals("sub_fmwjzh4uujc5jeid", response.getId());
    }

    @Test
    public void testUpdateSubscription_Success() {

        SubscriptionUpdateRequestDTO request = SubscriptionUpdateRequestDTO.builder()
                .billingType(BillingType.PIX)
                .status(StatusSubscription.INACTIVE)
                .nextDueDate("2024-11-12")
                .build();

        SubscriptionResponseDTO response = subscriptionService.updateSubscription("sub_fmwjzh4uujc5jeid", request);
        assertEquals(SubscriptionResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals("sub_fmwjzh4uujc5jeid", response.getId());

    }

    @Test
    public void testDeleteSubscription_Success() {
        DeleteResponseDTO response = subscriptionService.deleteSubscription("sub_ktl5kdmbsge5j8nm");

        assertEquals(DeleteResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals("sub_ktl5kdmbsge5j8nm", response.getId());
        assertTrue(response.isDeleted());
    }

    @Test
    public void testPaymentsListOfASubscription_Success() {
        PaymentsListResponseDTO response = subscriptionService.paymentsListOfASubscription("sub_fmwjzh4uujc5jeid", null);

        assertEquals(PaymentsListResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertNotNull(response.getData());
    }

    @Test
    public void testGenerateSubscriptionBooklet_Success() {
        String response = subscriptionService.generateSubscriptionBooklet("sub_u4c7g6d86ua100fg", 1, 2025, null, null);

        assertNotNull(response);
    }

    @Test
    public void testCreateConfigurationForIssuingInvoice_Success() {

        ConfigurationIssuingInvoicesRequestDTO request = ConfigurationIssuingInvoicesRequestDTO.builder()
                .municipalServiceId("teste id")
                .municipalServiceCode("teste code")
                .municipalServiceName("teste name")
                .updatePayment(false)
                .deductions(new BigDecimal("50.00"))
                .effectiveDatePeriod(InvoiceCreationPeriod.ON_PAYMENT_DUE_DATE)
                .receivedOnly(false)
                .daysBeforeDueDate(3)
                .observations("Testando observations")
                .taxes(TaxesRequestDTO.builder()
                        .retainIss(false)
                        .cofins(new BigDecimal("20"))
                        .csll(new BigDecimal("1"))
                        .inss(new BigDecimal("2"))
                        .ir(new BigDecimal("1"))
                        .pis(new BigDecimal("1"))
                        .iss(new BigDecimal("1"))
                        .build())
                .build();

        ConfigurationIssuingInvoicesResponseDTO response = subscriptionService.createConfigurationForIssuingInvoice("sub_h6lixs41o485n32d", request);

        assertEquals(ConfigurationIssuingInvoicesResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals("teste id", response.getMunicipalServiceId());
        assertEquals("teste code", response.getMunicipalServiceCode());
        assertEquals("teste name", response.getMunicipalServiceName());
        assertEquals("Testando observations", response.getObservations());

    }

    @Test
    public void testGetConfigurationForIssuingInvoice_Success() {

        ConfigurationIssuingInvoicesResponseDTO response = subscriptionService.getConfigurationForIssuingInvoice("sub_h6lixs41o485n32d");

        assertEquals(ConfigurationIssuingInvoicesResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals("teste id", response.getMunicipalServiceId());
        assertEquals("teste code", response.getMunicipalServiceCode());
        assertEquals("teste name", response.getMunicipalServiceName());
        assertEquals("Testando observations", response.getObservations());

    }

    @Test
    public void testUpdateConfigurationForIssuingInvoice_Success() {

        ConfigurationUpdateIssuingInvoicesRequestDTO request = ConfigurationUpdateIssuingInvoicesRequestDTO.builder()
                .deductions(new BigDecimal("45.00"))
                .receivedOnly(true)
                .effectiveDatePeriod(InvoiceCreationPeriod.ON_PAYMENT_DUE_DATE)
                .taxes(TaxesRequestDTO.builder()
                        .retainIss(false)
                        .cofins(new BigDecimal("2"))
                        .csll(new BigDecimal("3"))
                        .inss(new BigDecimal("2"))
                        .ir(new BigDecimal("4"))
                        .pis(new BigDecimal("2"))
                        .iss(new BigDecimal("2"))
                        .build())
                .build();

        ConfigurationIssuingInvoicesResponseDTO response = subscriptionService.updateConfigurationForIssuingInvoice("sub_h6lixs41o485n32d", request);
        assertEquals(ConfigurationIssuingInvoicesResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals("teste id", response.getMunicipalServiceId());
        assertEquals("teste code", response.getMunicipalServiceCode());
        assertEquals("teste name", response.getMunicipalServiceName());
        assertEquals("Testando observations", response.getObservations());
    }

    @Test
    public void testInvoicesForSubscriptionList_Success() {

        InvoicesListResponseDTO response = subscriptionService.invoicesForSubscriptionList("sub_h6lixs41o485n32d", null, null, null, null, null, null,
                null);

        assertEquals(InvoicesListResponseDTO.class, response.getClass());
        assertNotNull(response);

    }

    @Test
    public void testDeleteConfigurationForIssuingInvoice_Success() {

        DeleteResponseDTO response = subscriptionService.deleteConfigurationForIssuingInvoice("sub_h6lixs41o485n32d");

        assertEquals(DeleteResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertTrue(response.isDeleted());

    }

}
