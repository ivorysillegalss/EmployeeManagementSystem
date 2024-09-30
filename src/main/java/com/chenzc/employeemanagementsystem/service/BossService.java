package com.chenzc.employeemanagementsystem.service;

import com.chenzc.employeemanagementsystem.domain.BasicResult;

/**
 * boss操作
 *
 * @author chenz
 * @date 2024/09/27
 */
public interface BossService {

    /**
     * 展示所有请求 包括三种状态的
     *
     * @return {@link BasicResult }
     */
    public BasicResult showMeetingApplications();

    /**
     * @param meetingId id
     * @param opinion   表示是否批准会议 1代表通过 -1 代表不通过
     * @return {@link BasicResult }
     */
    public BasicResult permitMeetingApply(int meetingId, int opinion);


    /**
     * 表示
     *
     * @param empId
     * @param opinion 表示是否批准请假 1代表通过 -1 代表不通过
     * @return {@link BasicResult }
     */
    public BasicResult permitVacationApply(int empId, int opinion);


    /**
     * 表示
     *
     * @param empId
     * @param opinion 表示是否批准采购 1代表通过 -1 代表不通过
     * @return {@link BasicResult }
     */
    public BasicResult permitPurchaseApply(int empId, int opinion);

    /**
     * 表示
     *
     * @param positionChangeId
     * @param opinion          表示是否批准采购 1代表通过 -1 代表不通过
     * @return {@link BasicResult }
     */
    public BasicResult permitPositionChangeApply(int positionChangeId, int opinion);


    /**
     * 列举人事变动
     * @return {@link BasicResult }
     */
    public BasicResult listPositionChangeActivity();


    public BasicResult listPurchaseApplications();
}
