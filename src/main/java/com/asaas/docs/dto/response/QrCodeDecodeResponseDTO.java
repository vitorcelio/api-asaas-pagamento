package com.asaas.docs.dto.response;

import com.asaas.docs.enums.FinalityType;
import com.asaas.docs.enums.OriginType;
import com.asaas.docs.enums.QrCodeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QrCodeDecodeResponseDTO {

   private String payload;
   private QrCodeType type;
   private OriginType transactionOriginType;
   private String pixKey;
   private String conciliationIdentifier;
   private String endToEndIdentifier;
   private String dueDate;
   private String expirationDate;
   private FinalityType finality;
   private BigDecimal value;
   private BigDecimal changeValue;
   private BigDecimal interest;
   private BigDecimal fine;
   private BigDecimal discount;
   private BigDecimal totalValue;
   private boolean canBePaidWithDifferentValue;
   private boolean canBeModifyChangeValue;
   private ReceiverResponseDTO receiver;
   private PayerResponseDTO payer;
   private String description;
   private boolean canBePaid;
   private String cannotBePaidReason;

}
