package com.asaas.docs.service;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.dto.response.PaymentListResponseDTO;
import com.asaas.docs.service.payment.impl.PaymentServiceImpl;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PaymentTest {

    @Mock
    private HttpClient httpClient;

    @Mock
    private HttpResponse<String> httpResponse;

    private Gson gson;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        gson = new Gson();
        AsaasApiConfig.setApiKey(
                "");
    }

    @Test
    public void testCreatePayment_Success() throws IOException, InterruptedException {
        when(httpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenReturn(httpResponse);
        when(httpResponse.statusCode()).thenReturn(201);

    }

    @Test
    public void testPaymentList_Success() {
        PaymentListResponseDTO response = paymentService.paymentsList(null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null);

        assertEquals(PaymentListResponseDTO.class, response.getClass());
        assertEquals(ArrayList.class, response.getData().getClass());
    }

}
