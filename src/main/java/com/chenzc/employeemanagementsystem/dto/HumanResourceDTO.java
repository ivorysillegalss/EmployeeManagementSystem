package com.chenzc.employeemanagementsystem.dto;

import com.chenzc.employeemanagementsystem.domain.Employee;
import com.chenzc.employeemanagementsystem.domain.User;
import lombok.Getter;

/**
 * hr 映射类
 *
 * @author chenz
 * @date 2024/06/16
 */
@Getter
public class HumanResourceDTO {
    private Long hrId;
    private Long empId;
    private Long amount;
    private Long modifiedEmpId;
    private String newDepartment;
    private User user;
    private Employee employee;
    private String name;
}
