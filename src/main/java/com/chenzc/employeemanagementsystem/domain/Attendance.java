package com.chenzc.employeemanagementsystem.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Attendance {
    private Integer attendanceId;
    private Integer empId;
    private Integer date;
    private String status;

}
