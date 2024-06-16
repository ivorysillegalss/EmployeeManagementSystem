package com.chenzc.employeemanagementsystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum JobStatusEnums implements AbstractEnums{
    TRUE("1","在职"),
    FALSE("2","离职");
    private final String code;
    private final String message;
}
