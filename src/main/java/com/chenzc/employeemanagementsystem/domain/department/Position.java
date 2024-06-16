package com.chenzc.employeemanagementsystem.domain.department;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Position {
    private Integer positionId;
    private String positionName;
    private Integer departmentId;
    private Integer emps;
}
