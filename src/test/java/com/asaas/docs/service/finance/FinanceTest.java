package com.asaas.docs.service.finance;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.dto.response.BalanceResponseDTO;
import com.asaas.docs.dto.response.SplitValuesResponseDTO;
import com.asaas.docs.dto.response.StatisticsResponseDTO;
import com.asaas.docs.service.finance.impl.FinanceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static com.asaas.docs.configuration.AsaasApiConfig.API_KEY_ASAAS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FinanceTest {

    @InjectMocks
    private FinanceServiceImpl financeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        AsaasApiConfig.setApiKey(API_KEY_ASAAS);
    }

    @Test
    public void testBalance_Success() {
        BalanceResponseDTO response = financeService.getBalance();

        assertEquals(BalanceResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertNotNull(response.getBalance());
    }

    @Test
    public void testCollectionsStatistics_Success() {
        StatisticsResponseDTO response = financeService.collectionsStatistics(null, null, null, null, null, null,
                null, null, null, null);

        assertEquals(StatisticsResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertNotNull(response.getValue());
        assertNotNull(response.getNetValue());

    }

    @Test
    public void testGetSplitValues_Success() {
        SplitValuesResponseDTO response = financeService.getSplitValues();

        assertEquals(SplitValuesResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertNotNull(response.getIncome());
    }
}
