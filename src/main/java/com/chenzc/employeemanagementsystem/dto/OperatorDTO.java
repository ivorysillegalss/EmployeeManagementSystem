package com.chenzc.employeemanagementsystem.dto;

import com.chenzc.employeemanagementsystem.domain.User;
import com.chenzc.employeemanagementsystem.domain.operator.Operator;
import lombok.Getter;

@Getter
public class OperatorDTO {
    private String newRole;
    private Operator operator;
    private User user;
}
