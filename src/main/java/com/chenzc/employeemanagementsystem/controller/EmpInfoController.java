package com.chenzc.employeemanagementsystem.controller;

import com.chenzc.employeemanagementsystem.domain.BasicResult;
import com.chenzc.employeemanagementsystem.service.EmpService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * 展示员工基本信息
 * @author chenz
 * @date 2024/06/16
 */
@RestController
@RequestMapping("/user/emp")
public class EmpInfoController {

    @Resource
    private EmpService empService;

    @GetMapping("/reward/{id}")
    public BasicResult getReward(@PathVariable("id") Long id) {
        return empService.showReward(id);
    }

    @GetMapping("/salary/{id}")
    public BasicResult getSalary(@PathVariable("id") Long id) {
        return empService.showSalary(id);
    }

    @GetMapping("/attendance/{id}")
    public BasicResult getAttendance(@PathVariable("id") Long id) {
        return empService.showAttendance(id);
    }

    @PostMapping("/attendance/{id}")
    public BasicResult doAttendance(@PathVariable("id") Long id) {
        return empService.doAttendance(id);
    }

    @GetMapping("/department/{id}")
    public BasicResult getDepartment(@PathVariable("id") Long id) {
        return empService.showDepartment(id);
    }

    @GetMapping("/training/{id}")
    public BasicResult getTrainingHistory(@PathVariable("id") Long id) {
        return empService.showTrainingHistory(id);
    }
}
