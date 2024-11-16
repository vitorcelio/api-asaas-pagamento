package com.asaas.docs.dto.response;

import com.asaas.docs.enums.RecurrenceFrequency;
import com.asaas.docs.enums.RecurrenceOrigin;
import com.asaas.docs.enums.RecurrenceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecurrenceResponseDTO {

    private String id;
    private RecurrenceStatus status;
    private RecurrenceOrigin origin;
    private BigDecimal value;
    private RecurrenceFrequency frequency;
    private int quantity;
    private String startDate;
    private String finishDate;
    private boolean canBeCancelled;
    private ExternalAccountRecurrenceResponseDTO externalAccount;

}
