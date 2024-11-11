package com.asaas.docs.service.installments;

import com.asaas.docs.dto.request.InstallmentRequestDTO;
import com.asaas.docs.dto.request.InstallmentSplitsRequestDTO;
import com.asaas.docs.dto.response.*;
import com.asaas.docs.enums.PaymentStatus;
import lombok.NonNull;

public interface InstallmentsService {

    InstallmentResponseDTO createInstallment(@NonNull InstallmentRequestDTO request);

    InstallmentListResponseDTO installmentList(Integer offset, Integer limit);

    InstallmentResponseDTO getInstallment(@NonNull String id);

    DeleteResponseDTO deleteInstallment(@NonNull String id);

    PaymentsListResponseDTO paymentsListOfAInstallment(@NonNull String id, PaymentStatus status);

    String generateInstallmentBooklet(@NonNull String id, String sort, String order);

    InstallmentResponseDTO refundInstallment(@NonNull String id);

    InstallmentSplitsResponseDTO updateInstallmentSplits(@NonNull String id, @NonNull InstallmentSplitsRequestDTO request);

}
