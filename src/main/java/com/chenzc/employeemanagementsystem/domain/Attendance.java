package com.chenzc.employeemanagementsystem.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Attendance {
    @TableId
    private Integer attendanceId;
    private Integer empId;
    private Integer date;

    /**
     * @see com.chenzc.employeemanagementsystem.enums.JobAttendanceEnums
     */
    private String status;

}
