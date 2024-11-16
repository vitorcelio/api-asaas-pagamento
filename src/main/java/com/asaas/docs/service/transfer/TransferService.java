package com.asaas.docs.service.transfer;

import com.asaas.docs.dto.request.TransferAsaasAccountRequestDTO;
import com.asaas.docs.dto.request.TransferRequestDTO;
import com.asaas.docs.dto.response.TransferListResponseDTO;
import com.asaas.docs.dto.response.TransferResponseDTO;
import com.asaas.docs.enums.AccountTransferType;
import lombok.NonNull;

public interface TransferService {

    TransferResponseDTO transferAnotherInstitutionOrPix(@NonNull TransferRequestDTO request);

    TransferListResponseDTO transferList(String dateCreatedGe, String dateCreatedLe, String transferDateGe, String transferDateLe, AccountTransferType type);

    TransferResponseDTO transferAsaasAccount(@NonNull TransferAsaasAccountRequestDTO request);

    TransferResponseDTO getTransfer(@NonNull String id);

    TransferResponseDTO cancelTransfer(@NonNull String id);

}
