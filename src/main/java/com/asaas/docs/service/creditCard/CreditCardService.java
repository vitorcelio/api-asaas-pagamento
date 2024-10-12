package com.asaas.docs.service.creditCard;

import com.asaas.docs.dto.request.CreditCardTokenizationRequestDTO;
import com.asaas.docs.dto.response.CreditCardResponseDTO;
import lombok.NonNull;

public interface CreditCardService {

    CreditCardResponseDTO tokenizeCreditCard(@NonNull CreditCardTokenizationRequestDTO request);

}
