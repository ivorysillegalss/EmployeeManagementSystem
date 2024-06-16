package com.chenzc.employeemanagementsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenzc.employeemanagementsystem.domain.operator.OperationLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperationLogMapper extends BaseMapper<OperationLog> {
}
