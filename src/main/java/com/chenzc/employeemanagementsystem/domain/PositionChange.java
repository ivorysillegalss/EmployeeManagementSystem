package com.chenzc.employeemanagementsystem.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@Builder
public class PositionChange {
    @TableId
    private Integer positionChangeId;
    private Integer userId;
    private Integer hrId;
    private Boolean status;
    private String formalPosition;
    private String afterPosition;
}
