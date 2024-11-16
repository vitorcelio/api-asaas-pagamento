package com.asaas.docs.dto.response;

import com.asaas.docs.enums.BillStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillResponseDTO {

    private String object;
    private String id;
    private BillStatus status;
    private BigDecimal value;
    private BigDecimal discount;
    private BigDecimal interest;
    private BigDecimal fine;
    private String identificationField;
    private String dueDate;
    private String scheduleDate;
    private String paymentDate;
    private BigDecimal fee;
    private String description;
    private String companyName;
    private String transactionReceiptUrl;
    private boolean canBeCancelled;
    private String externalReference;
    private List<String> failReasons;

}
