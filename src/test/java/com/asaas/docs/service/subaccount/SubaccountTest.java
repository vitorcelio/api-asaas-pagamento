package com.asaas.docs.service.subaccount;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.dto.request.SubaccountRequestDTO;
import com.asaas.docs.dto.response.SubaccountListResponseDTO;
import com.asaas.docs.dto.response.SubaccountResponseDTO;
import com.asaas.docs.enums.CompanyType;
import com.asaas.docs.service.subaccount.impl.SubaccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static com.asaas.docs.configuration.AsaasApiConfig.API_KEY_ASAAS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SubaccountTest {

    @InjectMocks
    private SubaccountServiceImpl subaccountService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        AsaasApiConfig.setApiKey(API_KEY_ASAAS);
    }

    @Test
    public void testCreateSubaccount_Success() {

        SubaccountRequestDTO request = SubaccountRequestDTO.builder()
                .name("Dev Vítor")
                .email("xxx")
                .cpfCnpj("11463838000")
                .birthDate("2000-04-21")
                .companyType(CompanyType.MEI)
                .phone("xxx")
                .mobilePhone("xxx")
                .incomeValue(new BigDecimal("4000"))
                .address("Rua dos bobos")
                .addressNumber("Nº 0")
                .complement("Casa sem paredes")
                .province("Bairro nenhum")
                .postalCode("9312092")
                .build();

        SubaccountResponseDTO response = subaccountService.createSubaccount(request);
        assertEquals(SubaccountResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertNotNull(response.getId());
    }

    @Test
    public void testSubaccountsList_Success() {
        SubaccountListResponseDTO response = subaccountService.subaccountsList(null, null, null, null, null, null);

        assertEquals(SubaccountListResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertNotNull(response.getData());
    }

    @Test
    public void testGetSubaccount_Success() {
        SubaccountResponseDTO response = subaccountService.getSubaccount("626d0373-fe4c-4d09-843e-c44aa3426d0e");

        assertEquals(SubaccountResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertNotNull(response.getId());

    }

}
