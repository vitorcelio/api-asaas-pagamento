package com.asaas.docs.dto.request;

import com.asaas.docs.enums.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentRequestDTO {

    private boolean availableAfterPayment;
    private DocumentType type;

}
