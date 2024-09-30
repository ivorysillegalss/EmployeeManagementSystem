package com.chenzc.employeemanagementsystem.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Builder
@Data
public class Purchase {
    @TableId
    private Integer purchaseId;
    private String entity;
    private Integer nums;
    private Boolean hrOpinion;
    private Boolean bossOpinion;
    private Integer userId;
}
