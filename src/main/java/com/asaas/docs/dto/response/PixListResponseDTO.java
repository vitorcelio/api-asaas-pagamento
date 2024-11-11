package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PixListResponseDTO {

    private int totalCount;
    private int limit;
    private int offset;
    private boolean hasMore;
    private List<PixResponseDTO> data;

}
