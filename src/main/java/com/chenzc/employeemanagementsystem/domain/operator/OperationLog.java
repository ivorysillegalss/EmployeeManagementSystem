package com.chenzc.employeemanagementsystem.domain.operator;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OperationLog {
    @TableId
    private Integer logId;
    private Integer operatorId;
    private String action;
    private Long logTime;
}
