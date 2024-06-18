package com.chenzc.employeemanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

public abstract class AbstractService {

    protected  <T> QueryWrapper<T> selectByEmpId(Long id) {
        return new QueryWrapper<T>().eq("emp_id", id);
    }

}
