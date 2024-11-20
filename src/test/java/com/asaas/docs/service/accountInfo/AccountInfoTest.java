package com.asaas.docs.service.accountInfo;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.dto.request.BusinessDataRequestDTO;
import com.asaas.docs.dto.request.CheckoutCustomizationRequestDTO;
import com.asaas.docs.dto.response.*;
import com.asaas.docs.enums.AccountRegistrationStatus;
import com.asaas.docs.enums.AccountStatus;
import com.asaas.docs.enums.CheckoutCustomizationStatus;
import com.asaas.docs.enums.PersonType;
import com.asaas.docs.service.accountInfo.impl.AccountInfoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Path;

import static com.asaas.docs.configuration.AsaasApiConfig.API_KEY_ASAAS;
import static org.junit.jupiter.api.Assertions.*;

public class AccountInfoTest {

    @InjectMocks
    private AccountInfoServiceImpl accountInfoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        AsaasApiConfig.setApiKey(API_KEY_ASAAS);
    }

    @Test
    public void testGetBusinessData_Success() {
        BusinessDataResponseDTO response = accountInfoService.getBusinessData();

        assertEquals(BusinessDataResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals(AccountStatus.APPROVED, response.getStatus());
    }

    @Test
    public void testUpdateBusinessData_Success() {

        BusinessDataRequestDTO request = BusinessDataRequestDTO.builder()
                .personType(PersonType.FISICA)
                .birthDate("xxx")
                .name("Vítor Célio")
                .cpfCnpj("xxx")
                .postalCode("xxx")
                .incomeValue(new BigDecimal("xxx"))
                .email("celiovitor62@gmail.com")
                .phone("xxx")
                .mobilePhone("xxx")
                .companyName("xxx")
                .address("xxx")
                .addressNumber("xxx")
                .complement("xxx")
                .province("Caxias do Sul, RS")
                .site("https://vitorcelio.vercel.app")
                .build();

        BusinessDataResponseDTO response = accountInfoService.updateBusinessData(request);
        assertEquals(BusinessDataResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals(AccountStatus.AWAITING_ACTION_AUTHORIZATION, response.getStatus());

    }

    @Test
    public void testCheckoutCustomization_Success() {

        File file = new File("C:/Users/celio/Pictures/capa-pc3.png");

        Path path = file.toPath();

        CheckoutCustomizationRequestDTO request = CheckoutCustomizationRequestDTO.builder()
                .logoBackgroundColor("#0015ff")
                .infoBackgroundColor("#07248e")
                .fontColor("#e8e8e8")
                .enabled(true)
                .build();

        CheckoutCustomizationResponseDTO response = accountInfoService.checkoutCustomization(request, path);
        assertEquals(CheckoutCustomizationResponseDTO.class, response.getClass());
        assertNotNull(response);

    }

    @Test
    public void testGetPersonalizationSettings_Success() {
        PersonalizationSettingsResponseDTO response = accountInfoService.getPersonalizationSettings();

        assertEquals(PersonalizationSettingsResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals(CheckoutCustomizationStatus.APPROVED, response.getStatus());
    }

    @Test
    public void testGetAsaasAccountNumber_Success() {
        AsaasAccountNumberResponseDTO response = accountInfoService.getAsaasAccountNumber();

        assertEquals(AsaasAccountNumberResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertNotNull(response.getAgency());
        assertNotNull(response.getAccount());
        assertNotNull(response.getAccountDigit());
    }

    @Test
    public void testGetAccountFee_Success() {
        AccountFeesResponseDTO response = accountInfoService.getAccountFee();

        assertEquals(AccountFeesResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertNotNull(response.getPayment());
        assertNotNull(response.getTransfer());
        assertNotNull(response.getNotification());
        assertNotNull(response.getCreditBureauReport());
        assertNotNull(response.getInvoice());
        assertNotNull(response.getAnticipation());
    }

    @Test
    public void testCheckAccountRegistrationStatus_Success() {
        CheckAccountRegistrationStatusResponseDTO response = accountInfoService.checkAccountRegistrationStatus();

        assertEquals(CheckAccountRegistrationStatusResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertEquals(AccountRegistrationStatus.APPROVED, response.getCommercialInfo());
        assertEquals(AccountRegistrationStatus.APPROVED, response.getBankAccountInfo());
        assertEquals(AccountRegistrationStatus.APPROVED, response.getDocumentation());
        assertEquals(AccountRegistrationStatus.APPROVED, response.getGeneral());
    }

    @Test
    public void testGetWallets_Success() {
        WalletIdListResponseDTO response = accountInfoService.getWalletId();

        assertEquals(WalletIdListResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertNotNull(response.getData());
    }

    @Test
    public void testDeleteWhiteLabelSubAccount_Success() {
        DeleteWhiteLabelResponseDTO response = accountInfoService.deleteWhiteLabelSubAccount("Apenas para testes");

        assertEquals(DeleteWhiteLabelResponseDTO.class, response.getClass());
        assertNotNull(response);
        assertNotNull(response.getObservations());
    }

}
