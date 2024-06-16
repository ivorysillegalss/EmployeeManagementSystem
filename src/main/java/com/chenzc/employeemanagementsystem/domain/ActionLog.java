package com.chenzc.employeemanagementsystem.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ActionLog {
    @TableId
    private Integer actionId;
    private Integer userId;
    private String description;
    private Boolean success;
}
