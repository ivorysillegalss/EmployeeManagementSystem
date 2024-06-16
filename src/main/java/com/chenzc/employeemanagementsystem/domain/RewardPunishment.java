package com.chenzc.employeemanagementsystem.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RewardPunishment {
    private Integer rpId;
    private Integer empId;
    private String type;
    private String description;
    private Integer date;
}
