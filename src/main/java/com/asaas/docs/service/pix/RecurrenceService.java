package com.asaas.docs.service.pix;

import com.asaas.docs.dto.response.RecurrenceItemResponseDTO;
import com.asaas.docs.dto.response.RecurrenceItemsListResponseDTO;
import com.asaas.docs.dto.response.RecurrenceListResponseDTO;
import com.asaas.docs.dto.response.RecurrenceResponseDTO;
import com.asaas.docs.enums.RecurrenceStatus;
import lombok.NonNull;

import java.math.BigDecimal;

public interface RecurrenceService {

    RecurrenceListResponseDTO recurrenceList(Integer offset, Integer limit, RecurrenceStatus status, BigDecimal value
            , String searchText);

    RecurrenceResponseDTO getRecurrence(@NonNull String id);

    RecurrenceResponseDTO cancelRecurrence(@NonNull String id);

    RecurrenceItemsListResponseDTO recurrenceItemsList(@NonNull String id, Integer offset, Integer limit);

    RecurrenceItemResponseDTO cancelRecurrenceItem(@NonNull String id);

}
