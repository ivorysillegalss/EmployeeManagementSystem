package com.chenzc.employeemanagementsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenz
 * @date 2024/06/14
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Integer userId;

    private String username;

    private String password;

    private String role;

    private String email;

    private String phone;

    private Integer createTIme;

    private Integer updateTime;
}
