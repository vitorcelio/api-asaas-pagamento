package com.asaas.docs.service.customer;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.dto.request.CustomerRequestDTO;
import com.asaas.docs.dto.response.CustomerListResponseDTO;
import com.asaas.docs.dto.response.CustomerResponseDTO;
import com.asaas.docs.dto.response.DeleteResponseDTO;
import com.asaas.docs.dto.response.NotificationsListResponseDTO;
import com.asaas.docs.service.customer.impl.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static com.asaas.docs.configuration.AsaasApiConfig.API_KEY_ASAAS;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        AsaasApiConfig.setApiKey(API_KEY_ASAAS);
    }

    @Test
    public void testCreateCustomer_Success() {

        CustomerRequestDTO request = CustomerRequestDTO.builder()
                .name("Vítor Célio")
                .cpfCnpj("24971563792")
                .build();

        CustomerResponseDTO response = customerService.createCustomer(request);

        assertEquals(CustomerResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals(request.getName(), response.getName());
        assertEquals(request.getCpfCnpj(), response.getCpfCnpj());

    }

    @Test
    public void testCustomerList_Success() {
        CustomerListResponseDTO response = customerService.customerList(null, null, null, null, null, null, null);

        assertEquals(CustomerListResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertNotEquals(null, response.getData());
    }

    @Test
    public void testGetCustomer_Success() {
        CustomerResponseDTO response = customerService.getCustomer("cus_000006287494");

        assertEquals(CustomerResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals("cus_000006287494", response.getId());
    }

    @Test
    public void testUpdateCustomer_Success() {

        CustomerRequestDTO request = CustomerRequestDTO.builder()
                .name("Vítor Célio Edit")
                .cpfCnpj("24971563792")
                .build();

        CustomerResponseDTO response = customerService.updateCustomer("cus_000006287494", request);

        assertEquals(CustomerResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals(request.getName(), response.getName());
        assertEquals(request.getCpfCnpj(), response.getCpfCnpj());
    }

    @Test
    public void testDeleteCustomer_Success() {
        DeleteResponseDTO response = customerService.deleteCustomer("cus_000006287494");

        assertEquals(DeleteResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals("cus_000006287494", response.getId());
        assertTrue(response.isDeleted());
    }

    @Test
    public void testRestoreCustomer_Success() {
        CustomerResponseDTO response = customerService.restoreCustomer("cus_000006287494");

        assertEquals(CustomerResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals("cus_000006287494", response.getId());
    }

    @Test
    public void testNotificationListCustomer_Success() {
        NotificationsListResponseDTO response = customerService.notificationListCustomer("cus_000006287494");

        assertEquals(NotificationsListResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertNotEquals(null, response.getData());
    }

}
