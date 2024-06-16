package com.chenzc.employeemanagementsystem.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author chenz
 * @date 2024/06/14
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class User {
    @TableId
    private Integer userId;

    private String username;

    private String password;

    private String role;

    private String email;

    private String phone;

    private Integer createTIme;

    private Integer updateTime;
}
