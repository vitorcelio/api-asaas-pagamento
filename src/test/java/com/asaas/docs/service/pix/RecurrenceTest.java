package com.asaas.docs.service.pix;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.service.pix.impl.RecurrenceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class RecurrenceTest {

    @InjectMocks
    private RecurrenceServiceImpl recurrenceService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        AsaasApiConfig.setApiKey(AsaasApiConfig.API_KEY_ASAAS);
    }

    @Test
    public void testRecurrenceList_Success() {

    }

    @Test
    public void testGetRecurrence_Success() {

    }

    @Test
    public void testCancelRecurrence_Success() {

    }

    @Test
    public void testRecurrenceItemsList_Success() {

    }

    @Test
    public void testCancelRecurrenceItem_Success() {

    }

}
