package com.pagamentos.asaas.dto.response;

import com.pagamentos.asaas.enums.StatusRefunds;
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
    private StatusRefunds status;
    private BigDecimal value;
    private String description;
    private String transactionReceiptUrl;

}
