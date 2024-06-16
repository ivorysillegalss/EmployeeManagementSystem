package com.chenzc.employeemanagementsystem.domain.department;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Position {
    @TableId
    private Integer positionId;
    private String positionName;
    private Integer departmentId;
    private Integer emps;
}
