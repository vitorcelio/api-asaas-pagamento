package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationListResponseDTO {

    private String object;
    private boolean hasMore;
    private int totalCount;
    private int limit;
    private int offset;
    private List<NotificationResponseDTO> data;

}
