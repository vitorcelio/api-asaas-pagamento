package com.asaas.docs.service.bill;

import com.asaas.docs.dto.request.BillRequestDTO;
import com.asaas.docs.dto.request.SimulateBillRequestDTO;
import com.asaas.docs.dto.response.BillListResponseDTO;
import com.asaas.docs.dto.response.BillResponseDTO;
import com.asaas.docs.dto.response.SimulateBillResponseDTO;
import lombok.NonNull;

public interface BillService {

    BillResponseDTO createBillPayment(@NonNull BillRequestDTO request);

    BillListResponseDTO billListPayments(Integer offset, Integer limit);

    SimulateBillResponseDTO simulateBillPayment(@NonNull SimulateBillRequestDTO request);

    BillResponseDTO getBillPayment(@NonNull String id);

    BillResponseDTO cancelBillPayment(@NonNull String id);

}
