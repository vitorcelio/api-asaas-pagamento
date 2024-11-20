package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubaccountListResponseDTO {

    private String object;
    private boolean hasMore;
    private int totalCount;
    private int limit;
    private int offset;
    private List<SubaccountResponseDTO> data;

}
