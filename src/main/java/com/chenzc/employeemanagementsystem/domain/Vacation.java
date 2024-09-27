package com.chenzc.employeemanagementsystem.domain;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@Builder
public class Vacation {
    private Integer vacationId;
    private Integer userId;
    private Boolean hrOpinion;
    private Boolean bossOpinion;
}
