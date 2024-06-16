package com.chenzc.employeemanagementsystem.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Salary {
    @TableId
    private Integer salaryId;
    private Integer empId;
    private Integer bonus;
    private Integer deductions;
    private Integer totalSalary;
    private Long salaryDate;
}
