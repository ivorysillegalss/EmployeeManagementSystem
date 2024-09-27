package com.chenzc.employeemanagementsystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EventStatusEnums implements AbstractEnums {
    APPLYING("0", "申请中"),
    SUCCESS_APPLY("1", "申请成功"),
    FAIL_APPLY("-1", "申请失败");
    private final String code;
    private final String message;
}
