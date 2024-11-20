package com.asaas.docs.service.subaccount;

import com.asaas.docs.dto.request.SubaccountRequestDTO;
import com.asaas.docs.dto.response.SubaccountListResponseDTO;
import com.asaas.docs.dto.response.SubaccountResponseDTO;
import lombok.NonNull;

public interface SubaccountService {

    SubaccountResponseDTO createSubaccount(@NonNull SubaccountRequestDTO request);

    SubaccountListResponseDTO subaccountsList(Integer offset, Integer limit, String cpfCnpj, String email,
                                              String name, String walletId);

    SubaccountResponseDTO getSubaccount(@NonNull String id);

}
