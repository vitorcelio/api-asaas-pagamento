package com.asaas.docs.service.subscription;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.dto.request.SubscriptionRequestDTO;
import com.asaas.docs.dto.request.SubscriptionUpdateRequestDTO;
import com.asaas.docs.dto.response.DeleteResponseDTO;
import com.asaas.docs.dto.response.PaymentsListResponseDTO;
import com.asaas.docs.dto.response.SubscriptionResponseDTO;
import com.asaas.docs.dto.response.SubscriptionsListResponseDTO;
import com.asaas.docs.enums.BillingType;
import com.asaas.docs.enums.CycleType;
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

}
