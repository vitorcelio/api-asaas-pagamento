package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferFeeResponseDTO {

    private int monthlyTransfersWithoutFee;
    private TedTransferFeeResponseDTO ted;
    private PixTransferFeeResponseDTO pix;

}
