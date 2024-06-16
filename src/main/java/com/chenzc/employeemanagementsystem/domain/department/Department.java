package com.chenzc.employeemanagementsystem.domain.department;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Department {
    private Integer departmentId;
    private String departmentName;
    private String description;
    private Integer emps;

}
