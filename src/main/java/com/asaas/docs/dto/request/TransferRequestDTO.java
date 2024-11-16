package com.asaas.docs.dto.request;

import com.asaas.docs.enums.AddressPixKeyType;
import com.asaas.docs.enums.TransferType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransferRequestDTO {

    private BigDecimal value;
    private BankAccountRequestDTO bankAccount;
    private TransferType operationType;
    private String pixAddressKey;
    private AddressPixKeyType pixAddressKeyType;
    private String description;
    private String scheduleDate;
    private String externalReference;
    private RecurrenceRequestDTO recurring;

}
