package com.chenzc.employeemanagementsystem.domain.operator;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OperatorLog {
    private Integer logId;
    private Integer operatorId;
    private String action;
    private Integer logTime;
}
