package com.asaas.docs.service.finance;

import com.asaas.docs.dto.response.BalanceResponseDTO;
import com.asaas.docs.dto.response.SplitValuesResponseDTO;
import com.asaas.docs.dto.response.StatisticsResponseDTO;
import com.asaas.docs.enums.BillingType;

public interface FinanceService {

    BalanceResponseDTO getBalance();

    StatisticsResponseDTO collectionsStatistics(String customer, BillingType billingType, Boolean anticipated,
                                                String dateCreatedGe, String dateCreatedLe, String dueDateGe,
                                                String dueDateLe, String estimatedCreditDateGe,
                                                String estimatedCreditDateLe, String externalReference);

    SplitValuesResponseDTO getSplitValues();

}
