package com.chenzc.employeemanagementsystem.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@Builder
public class Vacation {
    @TableId
    private Integer vacationId;
    private Integer userId;
    private Boolean hrOpinion;
    private Boolean bossOpinion;
    private Integer time;
}
