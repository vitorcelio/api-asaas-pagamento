package com.asaas.docs.dto.request;

import com.asaas.docs.enums.ScheduleOffset;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.asaas.docs.enums.ScheduleOffset.ONE_DAY;
import static com.asaas.docs.enums.ScheduleOffset.ZERO_DAYS;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationRequestDTO {

    private String id;
    private boolean enabled;
    private boolean emailEnabledForProvider;
    private boolean smsEnabledForProvider;
    private boolean emailEnabledForCustomer;
    private boolean smsEnabledForCustomer;
    private boolean phoneCallEnabledForCustomer;
    private boolean whatsappEnabledForCustomer;
    private int scheduleOffset;

}
