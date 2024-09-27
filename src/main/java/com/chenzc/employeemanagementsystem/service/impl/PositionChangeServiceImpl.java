package com.chenzc.employeemanagementsystem.service.impl;

import com.chenzc.employeemanagementsystem.domain.BasicResult;
import com.chenzc.employeemanagementsystem.domain.PositionChange;
import com.chenzc.employeemanagementsystem.mapper.PositionChangeMapper;
import com.chenzc.employeemanagementsystem.service.PositionChangeService;
import jakarta.annotation.Resource;

public class PositionChangeServiceImpl implements PositionChangeService {

    @Resource
    private PositionChangeMapper positionChangeMapper;

    @Override
    public BasicResult insertPositionChangeApply(Integer userId, Integer hrId, String afterPosition, String formalPosition) {
        positionChangeMapper.insert(PositionChange.builder().afterPosition(afterPosition).userId(userId)
                .hrId(hrId).status(0).formalPosition(formalPosition).build());
        return BasicResult.success();
    }

}
