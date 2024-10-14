package com.asaas.docs.dto.response;

import com.asaas.docs.enums.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentResponseDTO {

    private String object;
    private String id;
    private String name;
    private DocumentType type;
    private boolean availableAfterPayment;
    private FileResponseDTO file;
    private boolean deleted;

}
