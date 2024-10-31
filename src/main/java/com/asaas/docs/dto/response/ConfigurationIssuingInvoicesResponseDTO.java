package com.asaas.docs.dto.response;

import com.asaas.docs.enums.InvoiceCreationPeriod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigurationIssuingInvoicesResponseDTO {

    private String municipalServiceId;
    private String municipalServiceCode;
    private String municipalServiceName;
    private BigDecimal deductions;
    private InvoiceCreationPeriod invoiceCreationPeriod;
    private int daysBeforeDueDate;
    private boolean receivedOnly;
    private String observations;
    private TaxesResponseDTO taxes;

}
