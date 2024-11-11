package com.asaas.docs.service.pix;

import com.asaas.docs.dto.request.PixRequestDTO;
import com.asaas.docs.dto.request.QrCodeRequestDTO;
import com.asaas.docs.dto.response.DeleteResponseDTO;
import com.asaas.docs.dto.response.PixListResponseDTO;
import com.asaas.docs.dto.response.PixResponseDTO;
import com.asaas.docs.dto.response.QrCodeResponseDTO;
import com.asaas.docs.enums.PixKeyStatus;
import lombok.NonNull;

public interface PixService {

    PixResponseDTO createKey(@NonNull PixRequestDTO request);

    PixListResponseDTO keysList(Integer offset, Integer limit, PixKeyStatus status, String statusList);

    PixResponseDTO getKey(@NonNull String id);

    PixResponseDTO deleteKey(@NonNull String id);

    QrCodeResponseDTO createStaticQrCode(QrCodeRequestDTO request);

    DeleteResponseDTO deleteStaticQrCode(@NonNull String id);

}
