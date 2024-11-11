package com.asaas.docs.dto.request;

import com.asaas.docs.enums.PixType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PixRequestDTO {

    private PixType type;

}
