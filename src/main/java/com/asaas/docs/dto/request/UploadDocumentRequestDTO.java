package com.asaas.docs.dto.request;

import com.asaas.docs.enums.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UploadDocumentRequestDTO {

    private boolean availableAfterPayment;
    private DocumentType type;
    private File file;

}
