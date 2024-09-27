package com.chenzc.employeemanagementsystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JobRuleEnums implements AbstractEnums {
    OPERATOR("1", "管理员"),
    HR("2", "HR"),
    EMPLOYEE("3", "员工");
    private final String code;
    private final String message;
}
