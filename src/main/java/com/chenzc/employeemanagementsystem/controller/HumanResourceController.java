package com.chenzc.employeemanagementsystem.controller;

import com.chenzc.employeemanagementsystem.domain.BasicResult;
import com.chenzc.employeemanagementsystem.domain.Training;
import com.chenzc.employeemanagementsystem.dto.EventDTO;
import com.chenzc.employeemanagementsystem.dto.HumanResourceDTO;
import com.chenzc.employeemanagementsystem.dto.PositionChangeDTO;
import com.chenzc.employeemanagementsystem.service.EmpService;
import com.chenzc.employeemanagementsystem.service.HumanResourceService;
import com.chenzc.employeemanagementsystem.service.PositionChangeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hr")
public class HumanResourceController {

    @Resource
    private HumanResourceService humanResourceService;

    @Resource
    private PositionChangeService positionChangeService;

    @GetMapping
    public BasicResult showEmpInfo() {
        return humanResourceService.showEmployeeInfo();
    }

    @PostMapping("/train/{hrId}")
    public BasicResult doTraining(@PathVariable("hrId") Long hrId, @RequestBody Training training) {
        return humanResourceService.doTraining(hrId, training);
    }

    @PostMapping("/bonus/{hrId}")
    public BasicResult doBonus(@PathVariable("hrId") Long hrId, @RequestBody HumanResourceDTO humanResourceDTO) {
        return humanResourceService.doBonus(hrId, humanResourceDTO.getEmpId(), humanResourceDTO.getAmount());
    }

    @PostMapping("/deductions/{hrId}")
    public BasicResult doDeductions(@PathVariable("hrId") Long hrId, @RequestBody HumanResourceDTO humanResourceDTO) {
        return humanResourceService.doDeductions(hrId, humanResourceDTO.getEmpId(), humanResourceDTO.getAmount());
    }

    @PostMapping("/insert/user/{id}")
    public BasicResult insertEmployee(@PathVariable("id") Long id, @RequestBody HumanResourceDTO humanResourceDTO) {
        return humanResourceService.insertEmployee(id, humanResourceDTO.getUser(), humanResourceDTO.getEmployee());
    }

    @PostMapping("/fire/{hrId}")
    public BasicResult fireEmployee(@PathVariable("hrId") Long hrId, @RequestBody HumanResourceDTO humanResourceDTO) {
        return humanResourceService.fireEmployee(hrId, humanResourceDTO.getName());
    }

    @PostMapping("/modify/{hrId}")
    public BasicResult modifyEmployee(@PathVariable("hrId") Long hrId, @RequestBody HumanResourceDTO humanResourceDTO) {
        return humanResourceService.modifyDepartment(hrId, humanResourceDTO.getModifiedEmpId(), humanResourceDTO.getNewDepartment());
    }

    @PostMapping("/meeting")
    public BasicResult applyMeeting(@RequestBody EventDTO eventDTO) {
        return humanResourceService.applyMeeting(eventDTO.getHrId(), eventDTO.getName(), eventDTO.getLocation());
    }

    @GetMapping("/vacation")
    public BasicResult getDayOffInfo() {
        return humanResourceService.showDayOffApply();
    }

    @PostMapping("/vacation/{empId}/{opinion}")
    public BasicResult hrPermitDayOff(@PathVariable("empId") Long empId, @PathVariable("opinion") Long opinion) {
        return humanResourceService.hrPermitVacationApply(empId.intValue(), opinion.intValue());
    }

    @PostMapping("/purchase/{empId}/{opinion}")
    public BasicResult hrPermitPurchase(@PathVariable("empId") Long empId, @PathVariable("opinion") Long opinion) {
        return humanResourceService.hrPermitPurchaseApply(empId.intValue(), opinion.intValue());
    }

    @PostMapping("/position/change")
    public BasicResult positionChangeApply(@RequestBody PositionChangeDTO positionChangeDTO) {
        return positionChangeService.insertPositionChangeApply(positionChangeDTO.getUserId(), positionChangeDTO.getHrId(),
                positionChangeDTO.getAfterPosition(), positionChangeDTO.getFormalPosition());
    }
}
