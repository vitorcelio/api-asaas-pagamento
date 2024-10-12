package com.asaas.docs.service.split;

import com.asaas.docs.dto.response.SplitListResponseDTO;
import com.asaas.docs.dto.response.SplitResponseDTO;
import com.asaas.docs.enums.StatusSplit;
import lombok.NonNull;

public interface SplitService {

    SplitResponseDTO getSplitPaid(@NonNull String splitId);

    SplitListResponseDTO splitsPaidList(Integer offset, Integer limit, String paymentId, StatusSplit status,
                                        String paymentConfirmedDateGe, String paymentConfirmedDateLe,
                                        String creditDateGe, String creditDateLe);

    SplitResponseDTO getSplitReceived(@NonNull String splitId);

    SplitListResponseDTO splitsReceivedList(Integer offset, Integer limit, String paymentId, StatusSplit status,
                                            String paymentConfirmedDateGe, String paymentConfirmedDateLe,
                                            String creditDateGe, String creditDateLe);
}
