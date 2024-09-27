package com.chenzc.employeemanagementsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenzc.employeemanagementsystem.domain.Attendance;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AttendanceMapper extends BaseMapper<Attendance> {
}
