package com.chenzc.employeemanagementsystem.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Salary {
    private Integer salaryId;
    private Integer empId;
    private Integer Bonus;
    private Integer deductions;
    private Integer totalSalary;
    private Integer salaryDate;
}
