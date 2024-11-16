package com.asaas.docs.dto.response;

import com.asaas.docs.dto.request.BankAccountRequestDTO;
import com.asaas.docs.dto.request.TransferAsaasAccountRequestDTO;
import com.asaas.docs.enums.AccountTransferType;
import com.asaas.docs.enums.TransferStatus;
import com.asaas.docs.enums.TransferType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferResponseDTO {

    private String object;
    private String id;
    private AccountTransferType type;
    private String dateCreated;
    private BigDecimal value;
    private BigDecimal netValue;
    private TransferStatus status;
    private BigDecimal transferFee;
    private String effectiveDate;
    private String scheduleDate;
    private String endToEndIdentifier;
    private boolean authorized;
    private String failReason;
    private String externalReference;
    private String transactionReceiptUrl;
    private TransferType operationType;
    private String description;
    private String walletId;
    private BankAccountResponseDTO bankAccount;
    private AsaasAccountResponseDTO account;

}
