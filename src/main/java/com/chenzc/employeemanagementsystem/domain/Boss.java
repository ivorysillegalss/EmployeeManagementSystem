package com.chenzc.employeemanagementsystem.domain;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@Builder
public class Boss {
    private String username;
    private String password;
    private String role;
    private String email;
    private String phone;
}
