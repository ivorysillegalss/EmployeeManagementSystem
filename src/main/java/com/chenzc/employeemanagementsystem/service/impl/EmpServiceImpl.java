package com.chenzc.employeemanagementsystem.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenzc.employeemanagementsystem.constants.CommonConstant;
import com.chenzc.employeemanagementsystem.domain.Attendance;
import com.chenzc.employeemanagementsystem.domain.BasicResult;
import com.chenzc.employeemanagementsystem.domain.RewardPunishment;
import com.chenzc.employeemanagementsystem.domain.Vacation;
import com.chenzc.employeemanagementsystem.mapper.*;
import com.chenzc.employeemanagementsystem.service.EmpService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class EmpServiceImpl extends AbstractService implements EmpService {

    @Resource
    private VacationMapper vacationMapper;

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
        return BasicResult.success(rewardPunishmentMapper.selectList(selectByEmpId(id)));
    }

    @Override
    public BasicResult showSalary(Long id) {
        return BasicResult.success(salaryMapper.selectList(selectByEmpId(id)));
    }

    @Override
    public BasicResult showDepartment(Long id) {
        return BasicResult.success(departmentMapper.selectList(selectByEmpId(id)));
    }

    @Override
    public BasicResult showTrainingHistory(Long id) {
        return BasicResult.success(trainingMapper.selectList(selectByEmpId(id)));
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
        return BasicResult.success(attendanceMapper.selectList(selectByEmpId(id)));
    }

    @Override
    public BasicResult takingDayOffApply(Long empId) {
        vacationMapper.insert(Vacation.builder().bossOpinion(Boolean.FALSE).hrOpinion(Boolean.FALSE).userId(empId.intValue()).time((int) System.currentTimeMillis()).build());
        return BasicResult.success();
    }

}
