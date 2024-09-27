package com.chenzc.employeemanagementsystem.service;

import com.chenzc.employeemanagementsystem.domain.BasicResult;
import com.chenzc.employeemanagementsystem.domain.RewardPunishment;
import com.chenzc.employeemanagementsystem.domain.Salary;
import com.chenzc.employeemanagementsystem.domain.Training;
import com.chenzc.employeemanagementsystem.domain.department.Department;

/**
 * 员工身份的操作接口
 * @author chenz
 * @date 2024/06/16
 */
public interface EmpService {

    /**
     * 查看奖惩
     *
     * @param id
     * @return {@link RewardPunishment }
     */
    BasicResult showReward(Long id);

    /**
     * 查看薪水
     *
     * @param id
     * @return {@link Salary }
     */
    BasicResult showSalary(Long id);

    /**
     * 查看部门
     *
     * @param id
     * @return {@link Department }
     */
    BasicResult showDepartment(Long id);

    /**
     * 查看培训史
     *
     * @param id
     * @return {@link Training }
     */
    BasicResult showTrainingHistory(Long id);


    /**
     * 考勤
     * @param id
     * @return {@link BasicResult }
     */
    BasicResult doAttendance(Long id);

    /**
     * 查看考勤记录
     * @param id
     * @return {@link BasicResult }
     */
    BasicResult showAttendance(Long id);


    /**
     * 员工请假申请
     * @param empId 要请假的员工
     * @return {@link BasicResult }
     */
    BasicResult takingDayOffApply(Long empId);


    /**
     * 列举请假申请
     * @return {@link BasicResult }
     */
    BasicResult showDayOffApply();
}
