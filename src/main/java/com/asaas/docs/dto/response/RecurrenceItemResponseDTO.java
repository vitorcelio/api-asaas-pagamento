package com.asaas.docs.dto.response;

import com.asaas.docs.enums.RecurrenceItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecurrenceItemResponseDTO {

    private String id;
    private RecurrenceItemStatus status;
    private String scheduledDate;
    private boolean canBeCancelled;
    private int recurrenceNumber;
    private int quantity;
    private BigDecimal value;
    private String refusalReasonDescription;
    private ExternalAccountRecurrenceResponseDTO externalAccount;

}
