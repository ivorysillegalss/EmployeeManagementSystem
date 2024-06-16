package com.chenzc.employeemanagementsystem.service;

import com.chenzc.employeemanagementsystem.domain.BasicResult;
import com.chenzc.employeemanagementsystem.domain.User;
import com.chenzc.employeemanagementsystem.domain.operator.Operator;

/**
 * 操作员\管理员
 *
 * @author chenz
 * @date 2024/06/16
 */
public interface OperatorService {
    /**
     * 修改用户权限
     *
     * @param operatorId
     * @param userId
     * @param newRole
     * @return {@link BasicResult }
     */
    BasicResult modifyPermission(Long operatorId, Long userId, String newRole);

    /**
     * 增加新的操作员
     *
     * @param operatorId
     * @param operator
     * @param user
     * @return {@link BasicResult }
     */
    BasicResult insertNewOperator(Long operatorId, Operator operator, User user);


    /**
     * 获取操作日志 (单操作员)
     * @param operatorId
     * @return {@link BasicResult }
     */
    BasicResult showOperationLog(Long operatorId);

    /**
     * 获取操作日志 (所有人)
     * @return {@link BasicResult }
     */
    BasicResult showOperationLog();
}
