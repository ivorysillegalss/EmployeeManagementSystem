package com.chenzc.employeemanagementsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenzc.employeemanagementsystem.domain.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
