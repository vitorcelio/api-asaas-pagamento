package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecurrenceItemsListResponseDTO {

    private int offset;
    private int limit;
    private List<RecurrenceItemResponseDTO> data;


}
