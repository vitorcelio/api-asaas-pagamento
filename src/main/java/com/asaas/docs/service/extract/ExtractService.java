package com.asaas.docs.service.extract;

import com.asaas.docs.dto.response.ExtractListResponseDTO;

public interface ExtractService {

    ExtractListResponseDTO getExtractList(Integer offset, Integer limit, String startDate, String finishDate, String order);

}
