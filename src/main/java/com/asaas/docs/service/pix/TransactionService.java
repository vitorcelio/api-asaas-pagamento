package com.asaas.docs.service.pix;

import com.asaas.docs.dto.request.PixTransactionRequestDTO;
import com.asaas.docs.dto.request.QrCodePixRequestDTO;
import com.asaas.docs.dto.response.PixTransactionListResponseDTO;
import com.asaas.docs.dto.response.PixTransactionResponseDTO;
import com.asaas.docs.dto.response.QrCodeDecodeResponseDTO;
import com.asaas.docs.enums.TransactionStatus;
import com.asaas.docs.enums.TransactionType;
import lombok.NonNull;

public interface TransactionService {

    PixTransactionResponseDTO payQrCode(@NonNull PixTransactionRequestDTO request);

    QrCodeDecodeResponseDTO decodeQrCodeForPayment(@NonNull QrCodePixRequestDTO request);

    PixTransactionResponseDTO getPixTransaction(@NonNull String id);

    PixTransactionListResponseDTO transactionsList(Integer offset, Integer limit, TransactionStatus status, TransactionType type, String endToEndIdentifier);

    PixTransactionResponseDTO cancelScheduledTransaction(@NonNull String id);

}
