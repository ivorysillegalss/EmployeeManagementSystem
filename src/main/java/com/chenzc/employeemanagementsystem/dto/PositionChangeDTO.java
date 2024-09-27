package com.chenzc.employeemanagementsystem.dto;

import lombok.Getter;

@Getter
public class PositionChangeDTO {
    private Integer userId;
    private Integer hrId;
    private String afterPosition;
    private String formalPosition;
}
