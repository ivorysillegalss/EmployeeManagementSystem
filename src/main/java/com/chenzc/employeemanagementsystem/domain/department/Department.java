package com.chenzc.employeemanagementsystem.domain.department;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

/**
 * @author chenz
 * @date 2024/06/19
 */
@Builder
@Data
public class Department {
    @TableId
    private Integer departmentId;
    private String departmentName;
    private String description;
    private Integer emps;

}
