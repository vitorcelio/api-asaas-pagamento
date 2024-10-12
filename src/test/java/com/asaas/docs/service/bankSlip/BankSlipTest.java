package com.asaas.docs.service.bankSlip;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.dto.response.BankSlipRefundResponseDTO;
import com.asaas.docs.service.bankSlip.impl.BankSlipServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

public class BankSlipTest {

    private static final String API_KEY_ASAAS = "";

    @InjectMocks
    private BankSlipServiceImpl bankSlipService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        AsaasApiConfig.setApiKey(API_KEY_ASAAS);
    }

    @Test
    public void testBankSlipRefund_Success() {
        BankSlipRefundResponseDTO response = bankSlipService.bankSlipRefund("pay_dm3esz45fo1tfj0i");

        assertEquals(BankSlipRefundResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertNotEquals(null, response.getRequestUrl());
        assertNotNull(response);
    }

}
