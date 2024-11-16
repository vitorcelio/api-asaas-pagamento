package com.asaas.docs.service.bill;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.dto.request.BillRequestDTO;
import com.asaas.docs.dto.request.SimulateBillRequestDTO;
import com.asaas.docs.dto.response.BillListResponseDTO;
import com.asaas.docs.dto.response.BillResponseDTO;
import com.asaas.docs.dto.response.SimulateBillResponseDTO;
import com.asaas.docs.service.bill.impl.BillServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static com.asaas.docs.configuration.AsaasApiConfig.API_KEY_ASAAS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BillTest {

    @InjectMocks
    private BillServiceImpl billService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        AsaasApiConfig.setApiKey(API_KEY_ASAAS);
    }

    @Test
    public void testCreateBillPayment_Success() {

        BillRequestDTO request = BillRequestDTO.builder()
                .identificationField("46191110000000000000010364175017499090000003200")
                .build();

        BillResponseDTO response = billService.createBillPayment(request);
        assertEquals(BillResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals("46191110000000000000010364175017499090000003200", response.getIdentificationField().trim());

    }

    @Test
    public void testBillPayments_Success() {

        BillListResponseDTO response = billService.billListPayments(null, null);

        assertEquals(BillListResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertNotNull(response.getData());

    }

    @Test
    public void testSimulateBillPayment_Success() {

        SimulateBillRequestDTO request = SimulateBillRequestDTO.builder()
                .identificationField("46191110000000000000010362677014799030000003222")
                .build();

        SimulateBillResponseDTO response = billService.simulateBillPayment(request);
        assertEquals(SimulateBillResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals("46191110000000000000010362677014799030000003222", response.getBankSlipInfo().getIdentificationField().trim());

    }

    @Test
    public void testGetBillPayment_Success() {

        BillResponseDTO response = billService.getBillPayment("42bbe5e0-745f-463a-b5e9-46bd8dc8d92c");

        assertEquals(BillResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals("42bbe5e0-745f-463a-b5e9-46bd8dc8d92c", response.getId());

    }

    @Test
    public void testCancelBillPayment_Success() {

        BillResponseDTO response = billService.cancelBillPayment("42bbe5e0-745f-463a-b5e9-46bd8dc8d92c");

        assertEquals(BillResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals("42bbe5e0-745f-463a-b5e9-46bd8dc8d92c", response.getId());

    }

}
