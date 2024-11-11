package com.asaas.docs.dto.response;

import com.asaas.docs.enums.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PixTransactionResponseDTO {

    private String id;
    private String endToEndIdentifier;
    private FinalityType finality;
    private BigDecimal value;
    private BigDecimal changeValue;
    private BigDecimal refundedValue;
    private String effectiveDate;
    private String scheduledDate;
    private TransactionStatus status;
    private TransactionType type;
    private OriginType originType;
    private String conciliationIdentifier;
    private String description;
    private String transactionReceiptUrl;
    private String refusalReason;
    private boolean canBeCanceled;
    private OriginalTransactionResponseDTO originalTransaction;
    private ExternalAccountResponseDTO externalAccount;
    private QrCodePixTransactionResponseDTO qrCode;
    private String payment;
    private boolean canBeRefunded;
    private String refundDisabledReason;
    private BigDecimal chargedFeeValue;
    private String dateCreated;
    private String addressKey;
    private AddressPixKeyType addressKeyType;
    private String transferId;
    private String externalReference;

}
