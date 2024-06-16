package com.chenzc.employeemanagementsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenzc.employeemanagementsystem.domain.Salary;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SalaryMapper extends BaseMapper<Salary> {
}
