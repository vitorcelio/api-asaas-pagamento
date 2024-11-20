package com.asaas.docs.dto.response;

import com.asaas.docs.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityResponseDTO {

    private String object;
    private int id;
    private String ibgeCode;
    private String name;
    private String districtCode;
    private String district;
    private State state;

}
