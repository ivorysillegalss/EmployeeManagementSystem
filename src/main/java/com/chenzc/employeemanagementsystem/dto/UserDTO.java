package com.chenzc.employeemanagementsystem.dto;

import com.chenzc.employeemanagementsystem.domain.User;
import lombok.Data;

/**
 * 映射类
 * @author chenz
 * @date 2024/06/14
 */
@Data
public class UserDTO {
    private Integer userId;
    private String username;
    private String password;
    private String beforePassword;
    private String afterPassword;
    private User user;
}
