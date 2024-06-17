package com.chenzc.employeemanagementsystem.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.CharSequenceUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenzc.employeemanagementsystem.constants.CommonConstant;
import com.chenzc.employeemanagementsystem.domain.BasicResult;
import com.chenzc.employeemanagementsystem.domain.User;
import com.chenzc.employeemanagementsystem.dto.UserDTO;
import com.chenzc.employeemanagementsystem.enums.RespEnums;
import com.chenzc.employeemanagementsystem.mapper.UserMapper;
import com.chenzc.employeemanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author chenz
 * @date 2024/06/14
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public BasicResult login(UserDTO userDTO) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("username", userDTO.getUsername()).eq("password", userDTO.getPassword());
        List<User> users = userMapper.selectList(qw);
        if (users.size() == CommonConstant.LONG_TRUE) {
            User first = CollUtil.getFirst(users.iterator());
            return BasicResult.success(UserDTO.builder().role(first.getRole()).userId(first.getUserId()).build());
        }
        return BasicResult.fail();
    }

    @Override
    public BasicResult showInfo(Long userId) {
        User user = userMapper.selectById(userId);
        if (Objects.nonNull(user)) {
            return BasicResult.success(user);
        }
        return BasicResult.fail();
    }

    @Override
    public BasicResult resetPassword(UserDTO userDTO) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("username", userDTO.getUsername());
        User user = CollUtil.getFirst(userMapper.selectList(qw).iterator());
        if (user.getPassword().equals(userDTO.getBeforePassword())) {
            user.setPassword(userDTO.getAfterPassword());
            userMapper.updateById(user);
            return BasicResult.success();
        }
        return BasicResult.fail(RespEnums.PASSWORD_ERROR);
    }

    public BasicResult updateInfo(UserDTO userDTO) {
        int i = userMapper.updateById(userDTO.getUser());
        if (i == CommonConstant.INTEGER_TRUE) {
            return BasicResult.success();
        }
        return BasicResult.fail();
    }
}
