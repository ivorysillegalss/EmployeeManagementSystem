package com.chenzc.employeemanagementsystem.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RewardPunishment {
    @TableId
    private Integer rpId;
    private Integer empId;
    private String type;
    private String description;
    private Integer date;
}
