package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountFeesResponseDTO {

    private PaymentFeeResponseDTO payment;
    private TransferFeeResponseDTO transfer;
    private NotificationFeeResponseDTO notification;
    private CreditBureauReportResponseDTO creditBureauReport;
    private InvoiceFeeResponseDTO invoice;
    private AnticipationFeeResponseDTO anticipation;

}
