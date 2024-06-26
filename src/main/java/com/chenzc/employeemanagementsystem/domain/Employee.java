package com.chenzc.employeemanagementsystem.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.chenzc.employeemanagementsystem.enums.JobStatusEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 员工信息pojo类
 * @author chenz
 * @date 2024/06/14
 */
@Data
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Employee {
    @TableId
    private Integer empId;
    private String name;
    private Integer empTime;
    private Boolean gender;
    private String address;
    private String phone;
    private String email;
    private Integer departmentId;
    private String departmentName;
//    冗余数据 不用多查表
    private Integer positionId;
    private Integer titleId;
    private String status;
    private Integer userId;
}
