package com.asaas.docs.dto.response;

import com.asaas.docs.enums.RefundsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefundsResponseDTO {

    private Date dateCreated;
    private RefundsStatus status;
    private BigDecimal value;
    private String description;
    private String transactionReceiptUrl;

}
