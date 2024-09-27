package com.chenzc.employeemanagementsystem.service;

import com.chenzc.employeemanagementsystem.domain.BasicResult;
import com.chenzc.employeemanagementsystem.domain.Employee;
import com.chenzc.employeemanagementsystem.domain.Training;
import com.chenzc.employeemanagementsystem.domain.User;
import com.chenzc.employeemanagementsystem.dto.EventDTO;

/**
 * HR 可进行的增删改查
 * 结合redispipieline定时入库 TBD
 *
 * @author chenz
 * @date 2024/06/16
 */
// 职位不搞 跟部门一个样
public interface HumanResourceService {

    /**
     * 渲染所有员工信息
     *
     * @return {@link BasicResult }
     */
    BasicResult showEmployeeInfo();

    /**
     * 执行员工培训
     *
     * @return {@link BasicResult }
     */
    BasicResult doTraining(Long hrId, Training training);

    /**
     * 加奖金
     *
     * @param hrId
     * @param empId
     * @param amount
     * @return {@link BasicResult }
     */
    BasicResult doBonus(Long hrId, Long empId, Long amount);


    /**
     * 扣钱
     *
     * @param hrId
     * @param empId
     * @param amount
     * @return {@link BasicResult }
     */
    BasicResult doDeductions(Long hrId, Long empId, Long amount);

    /**
     * 招人
     *
     * @param hrId
     * @param user
     * @param employee
     * @return {@link BasicResult }
     */
    BasicResult insertEmployee(Long hrId, User user, Employee employee);

    /**
     * 裁员
     *
     * @param hrId
     * @param fireEmpName
     * @return {@link BasicResult }
     */
    BasicResult fireEmployee(Long hrId, String fireEmpName);

    /**
     * 修改职位
     *
     * @param hrId
     * @param modifiedEmpId
     * @param newDepartment
     * @return {@link BasicResult }
     */
    BasicResult modifyDepartment(Long hrId, Long modifiedEmpId, String newDepartment);


    BasicResult applyMeeting(Long hrId, String name, String location);


    /**
     * 列举请假申请
     *
     * @return {@link BasicResult }
     */
    BasicResult showDayOffApply();

    /**
     * 表示
     *
     * @param empId
     * @param opinion 表示是否批准会议 1代表通过 -1 代表不通过
     * @return {@link BasicResult }
     */
    public BasicResult hrPermitVacationApply(int empId, int opinion);

    /**
     * 表示
     *
     * @param empId
     * @param opinion 表示是否批准采购 1代表通过 -1 代表不通过
     * @return {@link BasicResult }
     */
    BasicResult hrPermitPurchaseApply(int empId, int opinion);
}
