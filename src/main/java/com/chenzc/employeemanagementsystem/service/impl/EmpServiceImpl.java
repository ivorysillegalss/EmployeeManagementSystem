package com.chenzc.employeemanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenzc.employeemanagementsystem.constants.CommonConstant;
import com.chenzc.employeemanagementsystem.domain.Attendance;
import com.chenzc.employeemanagementsystem.domain.BasicResult;
import com.chenzc.employeemanagementsystem.mapper.*;
import com.chenzc.employeemanagementsystem.service.EmpService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


@Service
public class EmpServiceImpl implements EmpService {

    @Resource
    private AttendanceMapper attendanceMapper;

    @Resource
    private DepartmentMapper departmentMapper;

    @Resource
    private SalaryMapper salaryMapper;

    @Resource
    private RewardPunishmentMapper rewardPunishmentMapper;

    @Resource
    private TrainingMapper trainingMapper;

    @Override
    public BasicResult showReward(Long id) {
        return BasicResult.success(rewardPunishmentMapper.selectById(id));
    }

    @Override
    public BasicResult showSalary(Long id) {
        return BasicResult.success(salaryMapper.selectById(id));
    }

    @Override
    public BasicResult showDepartment(Long id) {
        return BasicResult.success(departmentMapper.selectById(id));
    }

    @Override
    public BasicResult showTrainingHistory(Long id) {
        return BasicResult.success(trainingMapper.selectById(id));
    }

    @Override
    public BasicResult doAttendance(Long id) {
        Attendance attendance = Attendance.builder()
                .empId(id.intValue())
                .date(Long.valueOf(System.currentTimeMillis()).intValue())
                .status(CommonConstant.STRING_TRUE)
                .build();
        return BasicResult.success(attendanceMapper.insert(attendance));
    }

    @Override
    public BasicResult showAttendance(Long id) {
        QueryWrapper<Attendance> qw = new QueryWrapper<>();
        qw.eq("emp_id",id);
        return BasicResult.success(attendanceMapper.selectList(qw));
    }
}
