package com.chenzc.employeemanagementsystem.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ActionLog {
    private Integer actionId;
    private Integer userId;
    private String description;
    private Boolean success;
}
