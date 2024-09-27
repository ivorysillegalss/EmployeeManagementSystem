package com.chenzc.employeemanagementsystem.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * 响应枚举类
 * @author chenz
 * @date 2024/06/14
 */

@Getter
@AllArgsConstructor
public enum RespEnums implements AbstractEnums{
    SUCCESS("0","成功"),
    FAIL("1","失败"),
    PASSWORD_ERROR("2","密码错误");


    private final String code;
    private final String message;
}
