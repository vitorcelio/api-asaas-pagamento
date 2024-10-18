package com.asaas.docs.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public enum ScheduleOffset {

    ZERO_DAYS(0),
    ONE_DAY(1),
    FIVE_DAYS(5),
    SEVEN_DAYS(7),
    TEN_DAYS(10),
    FIFTEEN_DAYS(15),
    THIRTY_DAYS(30);

    private int value;

}
