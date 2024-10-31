package com.asaas.docs.dto.response;

import com.asaas.docs.enums.StatusInvoice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceResponseDTO {

    private String object;
    private String id;
    private StatusInvoice status;
    private String customer;
    private String payment;
    private String installment;
    private String type;
    private String statusDescription;
    private String pdfUrl;
    private String xmlUrl;
    private String rpsSerie;
    private String rpsNumber;
    private String number;
    private String validationCode;
    private String value;
    private BigDecimal deductions;
    private String effectiveDate;
    private String observations;
    private String estimatedTaxesDescription;
    private String externalReference;
    private TaxesResponseDTO taxes;
    private String municipalServiceId;
    private String municipalServiceCode;
    private String municipalServiceName;

}
