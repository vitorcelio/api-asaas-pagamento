package com.asaas.docs.dto.response;

import com.asaas.docs.enums.PixType;
import com.asaas.docs.enums.PixKeyStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PixResponseDTO {

    private String id;
    private String key;
    private PixType type;
    private PixKeyStatus status;
    private String dateCreated;
    private boolean canBeDeleted;
    private String cannotBeDeletedReason;
    private QrCodePixResponseDTO qrCode;

}
