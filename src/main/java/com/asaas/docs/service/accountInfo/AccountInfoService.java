package com.asaas.docs.service.accountInfo;

import com.asaas.docs.dto.request.BusinessDataRequestDTO;
import com.asaas.docs.dto.request.CheckoutCustomizationRequestDTO;
import com.asaas.docs.dto.response.*;
import lombok.NonNull;

import java.nio.file.Path;

public interface AccountInfoService {

    BusinessDataResponseDTO getBusinessData();

    BusinessDataResponseDTO updateBusinessData(@NonNull BusinessDataRequestDTO request);

    CheckoutCustomizationResponseDTO checkoutCustomization(@NonNull CheckoutCustomizationRequestDTO request, Path path);

    PersonalizationSettingsResponseDTO getPersonalizationSettings();

    AsaasAccountNumberResponseDTO getAsaasAccountNumber();

    AccountFeesResponseDTO getAccountFee();

    CheckAccountRegistrationStatusResponseDTO checkAccountRegistrationStatus();

    WalletIdListResponseDTO getWalletId();

    DeleteWhiteLabelResponseDTO deleteWhiteLabelSubAccount(@NonNull String removeReason);

}
