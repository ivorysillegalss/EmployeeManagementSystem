package com.chenzc.employeemanagementsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenzc.employeemanagementsystem.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * user的mapper
 * @author chenz
 * @date 2024/06/18
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
