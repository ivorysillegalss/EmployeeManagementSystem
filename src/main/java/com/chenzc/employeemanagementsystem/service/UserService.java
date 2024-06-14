package com.chenzc.employeemanagementsystem.service;

import com.chenzc.employeemanagementsystem.domain.BasicResult;
import com.chenzc.employeemanagementsystem.dto.UserDTO;

/**
 *
 * @author chenz
 * @date 2024/06/14
 */
public interface UserService {
    /**
     * 登录
     * @param userDTO
     * @return {@link BasicResult }
     */
    BasicResult login(UserDTO userDTO);

    /**
     * 展示个人信息
     *
     * @param userId
     * @return {@link BasicResult }
     */
    BasicResult showInfo(Long userId);

    /**
     * 重置密码
     * @param userDTO
     * @return {@link BasicResult }
     */
    BasicResult resetPassword(UserDTO userDTO);

    /**
     * 更新个人信息
     * @param userDTO
     * @return {@link BasicResult }
     */
    BasicResult updateInfo(UserDTO userDTO);
}
