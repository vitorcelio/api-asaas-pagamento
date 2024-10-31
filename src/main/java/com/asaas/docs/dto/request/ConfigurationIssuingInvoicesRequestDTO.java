package com.asaas.docs.dto.request;

import com.asaas.docs.enums.InvoiceCreationPeriod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConfigurationIssuingInvoicesRequestDTO {

    private String municipalServiceId;
    private String municipalServiceCode;
    private String municipalServiceName;
    private boolean updatePayment;
    private BigDecimal deductions;
    private InvoiceCreationPeriod effectiveDatePeriod;
    private int daysBeforeDueDate;
    private boolean receivedOnly;
    private String observations;
    private TaxesRequestDTO taxes;

}