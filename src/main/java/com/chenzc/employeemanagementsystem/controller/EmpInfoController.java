package com.chenzc.employeemanagementsystem.controller;

import com.chenzc.employeemanagementsystem.domain.BasicResult;
import com.chenzc.employeemanagementsystem.dto.PurchaseDTO;
import com.chenzc.employeemanagementsystem.service.EmpService;
import com.chenzc.employeemanagementsystem.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * 展示员工基本信息
 *
 * @author chenz
 * @date 2024/06/16
 */
@RestController
@RequestMapping("/user/emp")
public class EmpInfoController {

    @Resource
    private EmpService empService;

    @Resource
    private UserService userService;

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

    @PostMapping("/vacation/{empId}")
    public BasicResult takingDayOffApply(@PathVariable("empId") Long empId) {
        return empService.takingDayOffApply(empId);
    }

    @PostMapping("/purchase/{empId}")
    public BasicResult takingPurchaseApply(@PathVariable("empId") Long empId, @RequestBody PurchaseDTO purchaseDTO) {
        return userService.applyPurchase(empId.intValue(), purchaseDTO.getEntity(),purchaseDTO.getNums());
    }
}
