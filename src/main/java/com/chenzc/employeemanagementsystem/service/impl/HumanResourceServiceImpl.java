package com.chenzc.employeemanagementsystem.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenzc.employeemanagementsystem.constants.CommonConstant;
import com.chenzc.employeemanagementsystem.domain.*;
import com.chenzc.employeemanagementsystem.domain.department.Department;
import com.chenzc.employeemanagementsystem.enums.EventStatusEnums;
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
public class HumanResourceServiceImpl extends AbstractService implements HumanResourceService {

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


    @Resource
    private EventMapper eventMapper;

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
        List<Salary> salaries = salaryMapper.selectList(selectByEmpId(empId));
        Salary salary = CollUtil.getFirst(salaries.iterator());

        if (Objects.isNull(salary)) {
            salary = Salary.builder()
                    .empId(empId.intValue())
                    .basicSalary(CommonConstant.ORIGINAL_SALARY)
                    .bonus(CommonConstant.ORIGINAL_BONUS)
                    .deductions(CommonConstant.ORIGINAL_DEDUCTIONS)
                    .totalSalary(CommonConstant.ORIGINAL_SALARY)
                    .salaryDate(DateUtil.getLastDayOfMonthTimestamp())
                    .build();
            salary.setBonus(salary.getBonus() + amount.intValue());
            salary.setTotalSalary(salary.getTotalSalary() + amount.intValue());
            salaryMapper.insert(salary);
        } else {
            salary.setBonus(salary.getBonus() + amount.intValue());
            salary.setTotalSalary(salary.getTotalSalary() + amount.intValue());
            salaryMapper.updateById(salary);
        }
        return BasicResult.success();
    }

    @Override
    public BasicResult doDeductions(Long hrId, Long empId, Long amount) {
        List<Salary> salaries = salaryMapper.selectList(selectByEmpId(empId));
        Salary salary = CollUtil.getFirst(salaries.iterator());

        if (Objects.isNull(salary)) {
            salary = Salary.builder()
                    .empId(empId.intValue())
                    .bonus(CommonConstant.ORIGINAL_BONUS)
                    .deductions(CommonConstant.ORIGINAL_DEDUCTIONS)
                    .totalSalary(CommonConstant.ORIGINAL_SALARY)
                    .salaryDate(DateUtil.getLastDayOfMonthTimestamp())
                    .build();
            salary.setDeductions(salary.getDeductions() + amount.intValue());
            salary.setTotalSalary(salary.getTotalSalary() - amount.intValue());
            salaryMapper.insert(salary);
        } else {
            salary.setDeductions(salary.getDeductions() + amount.intValue());
            salary.setTotalSalary(salary.getTotalSalary() - amount.intValue());
            salaryMapper.updateById(salary);
        }
        return BasicResult.success();
    }

    @Override
    public BasicResult insertEmployee(Long hrId, User user, Employee employee) {
        userMapper.insert(user);
//        employee.setDepartmentName(departmentMapper.selectById(employee.getDepartmentId()).getDepartmentName());
        employeeMapper.insert(employee.setUserId(user.getUserId()));
        return BasicResult.success();
    }

    @Override
    public BasicResult fireEmployee(Long hrId, String fireEmpName) {
//        List<Employee> employees = employeeMapper.selectList(selectByEmpId(fireEmpId));
        QueryWrapper<Employee> employeeQueryWrapper = new QueryWrapper<>();
        QueryWrapper<Employee> name = employeeQueryWrapper.eq("name", fireEmpName);
        List<Employee> employees = employeeMapper.selectList(name);
        Employee employee = CollUtil.getFirst(employees);

        employee.setStatus(JobStatusEnums.FALSE.getCode());
        employeeMapper.updateById(employee);
        return BasicResult.success();
    }

    @Override
    public BasicResult modifyDepartment(Long hrId, Long modifiedEmpId, String newDepartment) {
        QueryWrapper<Department> qw = new QueryWrapper<>();
        qw.eq("department_name", newDepartment);
        List<Department> departments = departmentMapper.selectList(qw);
        Employee employee = employeeMapper.selectById(modifiedEmpId);
        Department first = CollUtil.getFirst(departments.iterator());
        employee.setDepartmentId(first.getDepartmentId());
        employee.setDepartmentName(first.getDepartmentName());
        employeeMapper.updateById(employee);
        return BasicResult.success();
    }

    @Override
    public BasicResult applyMeeting(Long hrId, String name, String location) {
        eventMapper.insert(Event.builder().location(location).name(name).status(Integer.parseInt(EventStatusEnums.APPLYING.getCode())).build());
        return BasicResult.success();
    }
}
