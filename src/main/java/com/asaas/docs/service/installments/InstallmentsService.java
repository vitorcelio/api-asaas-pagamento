package com.asaas.docs.service.installments;

import com.asaas.docs.dto.request.InstallmentRequestDTO;
import com.asaas.docs.dto.request.InstallmentSplitsRequestDTO;
import com.asaas.docs.dto.response.*;
import lombok.NonNull;

public interface InstallmentsService {

    InstallmentResponseDTO createInstallment(@NonNull InstallmentRequestDTO request);

    InstallmentListResponseDTO installmentList(Integer offset, Integer limit);

    InstallmentResponseDTO createInstallmentWithCreditCard(@NonNull InstallmentRequestDTO request);

    InstallmentResponseDTO getInstallment(@NonNull String id);

    DeleteResponseDTO deleteInstallment(@NonNull String id);

    PaymentListResponseDTO paymentListOfAInstallment(Integer offset, Integer limit);

    void generateInstallmentBooklet(@NonNull String id, String sort, String order);

    InstallmentResponseDTO refundInstallment(@NonNull String id);

    InstallmentSplitsResponseDTO updateInstallmentSplits(@NonNull String id, @NonNull InstallmentSplitsRequestDTO request);

}
