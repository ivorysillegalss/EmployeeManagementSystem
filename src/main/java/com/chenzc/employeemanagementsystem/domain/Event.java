package com.chenzc.employeemanagementsystem.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Builder
@Accessors(chain = true)
@Data
public class Event {
    @TableId
    private Integer eventId;
    private String name;
    private Integer time;
    private Integer status;
    private String location;
    private Integer hrId;
}
