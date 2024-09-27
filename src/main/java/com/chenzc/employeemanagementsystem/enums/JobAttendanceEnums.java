package com.chenzc.employeemanagementsystem.enums;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JobAttendanceEnums implements AbstractEnums {
    ATTEND("1","出勤"),
    DIS_ATTEND("2","缺勤"),
    BREAK("3","请假"),
    LATE("4","迟到"),
    LEAVE_EARLY("5","早退");
    private final String code;
    private final String message;
}
