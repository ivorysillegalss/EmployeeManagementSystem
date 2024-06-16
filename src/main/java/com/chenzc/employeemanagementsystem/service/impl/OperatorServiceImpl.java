package com.chenzc.employeemanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenzc.employeemanagementsystem.constants.CommonConstant;
import com.chenzc.employeemanagementsystem.domain.BasicResult;
import com.chenzc.employeemanagementsystem.domain.User;
import com.chenzc.employeemanagementsystem.domain.operator.OperationLog;
import com.chenzc.employeemanagementsystem.domain.operator.Operator;
import com.chenzc.employeemanagementsystem.mapper.OperationLogMapper;
import com.chenzc.employeemanagementsystem.mapper.OperatorMapper;
import com.chenzc.employeemanagementsystem.mapper.UserMapper;
import com.chenzc.employeemanagementsystem.service.OperatorService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OperatorServiceImpl implements OperatorService {

    @Resource
    private OperatorMapper operatorMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private OperationLogMapper operationLogMapper;

    @Override
    public BasicResult modifyPermission(Long operatorId, Long userId, String newRole) {
        User user = userMapper.selectById(userId);
        userMapper.updateById(user.setRole(newRole));
        operationLogMapper.insert(OperationLog.builder()
                .operatorId(operatorId.intValue())
                .logTime(System.currentTimeMillis())
                .action(CommonConstant.MODIFY_PERMISSION)
                .build());
        return BasicResult.success();
    }

    @Override
    public BasicResult insertNewOperator(Long operatorId, Operator operator, User user) {
        userMapper.insert(user);
        operatorMapper.insert(operator.setUserId(user.getUserId()));
        operationLogMapper.insert(OperationLog.builder()
                .operatorId(operatorId.intValue())
                .action(CommonConstant.INSERT_OPERATOR)
                .build());
        return BasicResult.success();
    }

    @Override
    public BasicResult showOperationLog(Long operatorId) {
        QueryWrapper<OperationLog> qw = new QueryWrapper<>();
        qw.eq("operator_id", operatorId);
        return BasicResult.success(operationLogMapper.selectList(qw));
    }

    @Override
    public BasicResult showOperationLog() {
        return BasicResult.success(operationLogMapper.selectList(null));
    }
}
