package com.pagamentos.asaas.dto.response;

import com.pagamentos.asaas.enums.BillingType;
import com.pagamentos.asaas.enums.StatusCobranca;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CobrancaResponseDTO {

    private String object;
    private String id;
    private String customer;
    private Date dateCreated;
    private Date dueDate;
    private String installment;
    private String subscription;
    private String paymentLink;
    private BigDecimal value;
    private BigDecimal netValue;
    private BillingType billingType;
    private StatusCobranca status;
    private String description;
    private int daysAfterDueDateToRegistrationCancellation;
    private String externalReference;
    private boolean canBePaidAfterDueDate;
    private String pixTransaction;
    private String pixQrCodeId;
    private BigDecimal originalValue;
    private BigDecimal interestValue;
    private Date originalDueDate;
    private Date paymentDate;
    private Date clientPaymentDate;
    private int installmentNumber;
    private String transactionReceiptUrl;
    private String nossoNumero;
    private String invoiceUrl;
    private String bankSplitUrl;
    private String invoiceNumber;
    private DiscountResponseDTO discount;
    private FineResponseDTO fine;
    private boolean deleted;
    private boolean postalService;
    private boolean anticipated;
    private boolean anticipable;
    private List<RefundsResponseDTO> refunds;
    private List<SplitResponseDTO> split;
    private ChargebackResponseDTO chargeback;


}
