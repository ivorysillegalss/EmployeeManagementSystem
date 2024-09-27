package com.chenzc.employeemanagementsystem.domain;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Builder
@Accessors(chain = true)
@Data
public class Event {
    private Integer eventId;
    private String name;
    private Integer time;
    private Integer status;
    private String location;
    private Integer hrId;
}
