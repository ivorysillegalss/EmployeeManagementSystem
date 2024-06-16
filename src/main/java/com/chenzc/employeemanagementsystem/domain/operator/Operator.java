package com.chenzc.employeemanagementsystem.domain.operator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Builder
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class Operator {
    private Integer operatorId;
    private Integer userId;
    private String operatorRole;
    private Integer updateAt;
    private Integer createAt;
}
