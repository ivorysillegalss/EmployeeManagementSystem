package com.chenzc.employeemanagementsystem.service;

import com.chenzc.employeemanagementsystem.domain.BasicResult;

/**
 * 人事变动
 * @author chenz
 * @date 2024/09/27
 */
public interface PositionChangeService {
    /**
     * 申请人事变动
     * @return {@link BasicResult }
     */
    BasicResult insertPositionChangeApply(Integer userId,Integer hrId,String afterPosition,String formalPosition);
}
