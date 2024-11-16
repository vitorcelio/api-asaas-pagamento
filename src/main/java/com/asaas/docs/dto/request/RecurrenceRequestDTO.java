package com.asaas.docs.dto.request;

import com.asaas.docs.enums.RecurrenceFrequency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecurrenceRequestDTO {

    private RecurrenceFrequency frequency;
    private int quantity;

}
