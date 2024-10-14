package com.asaas.docs.service.creditCard;

import com.asaas.docs.configuration.AsaasApiConfig;
import com.asaas.docs.dto.request.CreditCardHolderInfoRequestDTO;
import com.asaas.docs.dto.request.CreditCardRequestDTO;
import com.asaas.docs.dto.request.CreditCardTokenizationRequestDTO;
import com.asaas.docs.dto.response.CreditCardResponseDTO;
import com.asaas.docs.service.creditCard.impl.CreditCardServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static com.asaas.docs.configuration.AsaasApiConfig.API_KEY_ASAAS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CreditCardTest {

    @InjectMocks
    private CreditCardServiceImpl creditCardService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        AsaasApiConfig.setApiKey(API_KEY_ASAAS);
    }

    @Test
    public void testTokenizeCreditCard_Success() {

        CreditCardTokenizationRequestDTO request = CreditCardTokenizationRequestDTO.builder()
                .customer("cus_000005828409")
                .creditCard(CreditCardRequestDTO.builder()
                        .holderName("John Doe")
                        .number("1234567890123456")
                        .expiryMonth("10")
                        .expiryYear("2024")
                        .ccv("123")
                        .build())
                .creditCardHolderInfo(CreditCardHolderInfoRequestDTO.builder()
                        .name("John Doe")
                        .email("john.doe@asaas.com")
                        .cpfCnpj("61946019305")
                        .postalCode("65600440")
                        .addressNumber("123")
                        .phone("99988204161")
                        .build())
                .build();

        CreditCardResponseDTO response = creditCardService.tokenizeCreditCard(request);
        assertEquals(CreditCardResponseDTO.class, response.getClass());
        assertNotEquals(null, response);
        assertEquals("3456", response.getCreditCardNumber());

    }

}
