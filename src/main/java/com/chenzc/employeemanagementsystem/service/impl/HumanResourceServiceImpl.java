package com.chenzc.employeemanagementsystem.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenzc.employeemanagementsystem.constants.CommonConstant;
import com.chenzc.employeemanagementsystem.domain.*;
import com.chenzc.employeemanagementsystem.domain.department.Department;
import com.chenzc.employeemanagementsystem.enums.JobStatusEnums;
import com.chenzc.employeemanagementsystem.mapper.*;
import com.chenzc.employeemanagementsystem.service.HumanResourceService;
import com.chenzc.employeemanagementsystem.utils.DateUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;


//redis pipeline 定时任务 日志入库 没必要 TODO
@Service
public class HumanResourceServiceImpl implements HumanResourceService {

    @Resource
    private SalaryMapper salaryMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private DepartmentMapper departmentMapper;

    @Resource
    private TrainingMapper trainingMapper;

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public BasicResult showEmployeeInfo() {

//        闲着没事干可以搞个分页 TODO
        return BasicResult.success(employeeMapper.selectList(null));
    }

    @Override
    public BasicResult doTraining(Long hrId, Training training) {
        return BasicResult.success(trainingMapper.insert(training));
    }

    @Override
    public BasicResult doBonus(Long hrId, Long empId, Long amount) {
        Salary salary = salaryMapper.selectById(empId);
        if (Objects.isNull(salary)) {
            salary = Salary.builder()
                    .bonus(CommonConstant.ORIGINAL_BONUS)
                    .deductions(CommonConstant.ORIGINAL_DEDUCTIONS)
                    .totalSalary(CommonConstant.ORIGINAL_SALARY)
                    .salaryDate(DateUtil.getLastDayOfMonthTimestamp())
                    .build();
        }
        salary.setBonus(salary.getBonus() + amount.intValue());
        return BasicResult.success();
    }

    @Override
    public BasicResult doDeductions(Long hrId, Long empId, Long amount) {
        Salary salary = salaryMapper.selectById(empId);
        if (Objects.isNull(salary)) {
            salary = Salary.builder()
                    .bonus(CommonConstant.ORIGINAL_BONUS)
                    .deductions(CommonConstant.ORIGINAL_DEDUCTIONS)
                    .totalSalary(CommonConstant.ORIGINAL_SALARY)
                    .salaryDate(DateUtil.getLastDayOfMonthTimestamp())
                    .build();
        }
        salary.setDeductions(salary.getDeductions() + amount.intValue());
        return BasicResult.success();
    }

    @Override
    public BasicResult insertEmployee(Long hrId, User user, Employee employee) {
        userMapper.insert(user);
        employee.setDepartmentName(departmentMapper.selectById(employee.getDepartmentId()).getDepartmentName());
        employeeMapper.insert(employee.setUserId(user.getUserId()));
        return BasicResult.success();
    }

    @Override
    public BasicResult fireEmployee(Long hrId, Long fireEmpId) {
        Employee employee = employeeMapper.selectById(fireEmpId);
        employee.setStatus(JobStatusEnums.FALSE.getMessage());
        return BasicResult.success();
    }

    @Override
    public BasicResult modifyDepartment(Long hrId, Long modifiedEmpId, String newDepartment) {
        QueryWrapper<Department> qw = new QueryWrapper<>();
        qw.eq("department_name", newDepartment);
        List<Department> departments = departmentMapper.selectList(qw);
        Employee employee = employeeMapper.selectById(modifiedEmpId);
        employee.setDepartmentId(CollUtil.getFirst(departments.iterator()).getDepartmentId());
        return BasicResult.success();
    }
}
