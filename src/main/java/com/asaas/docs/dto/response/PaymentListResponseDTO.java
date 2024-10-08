package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentListResponseDTO {

    private String object;
    private boolean hasMore;
    private int totalCount;
    private int limit;
    private int offset;
    private List<PaymentResponseDTO> data;

}
