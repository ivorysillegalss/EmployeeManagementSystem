package com.chenzc.employeemanagementsystem.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Salary {
    private Integer salaryId;
    private Integer empId;
    private Integer bonus;
    private Integer deductions;
    private Integer totalSalary;
    private Long salaryDate;
}
