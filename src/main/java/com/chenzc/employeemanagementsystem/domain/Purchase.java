package com.chenzc.employeemanagementsystem.domain;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Builder
@Data
public class Purchase {
    private Integer purchaseId;
    private String entity;
    private Boolean hrOpinion;
    private Boolean bossOpinion;
    private Integer userId;
}
