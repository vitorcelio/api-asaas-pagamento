package com.asaas.docs.service.bankSlip;

import com.asaas.docs.dto.response.BankSlipRefundResponseDTO;
import lombok.NonNull;

public interface BankSlipService {

    BankSlipRefundResponseDTO bankSlipRefund(@NonNull String id);

}
