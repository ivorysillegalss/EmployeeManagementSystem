package com.chenzc.employeemanagementsystem.controller;

import com.chenzc.employeemanagementsystem.domain.BasicResult;
import com.chenzc.employeemanagementsystem.service.BossService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * boss相关操作
 *
 * @author chenz
 * @date 2024/09/27
 */
@RestController
@RequestMapping("/boss")
public class BossController {
    @Resource
    private BossService bossService;

    @GetMapping()
    public BasicResult getBossApply() {
        return bossService.showMeetingApplications();
    }

    @PostMapping("/permit/{meetingId}/{opinion}")
    public BasicResult permitApplications(@PathVariable("meetingId") Long meetingId, @PathVariable("opinion") Long opinion) {
        return bossService.permitMeetingApply(meetingId.intValue(),opinion.intValue());
    }

    @PostMapping("/vacations/{empId}/{opinion}")
    public BasicResult permitVacations(@PathVariable("empId") Long empId,@PathVariable("opinion") Long opinion){
        return bossService.permitVacationApply(empId.intValue(),opinion.intValue());
    }

    @PostMapping("/purchase/{empId}/{opinion}")
    public BasicResult permitPurchase(@PathVariable("empId") Long empId,@PathVariable("opinion") Long opinion){
        return bossService.permitPurchaseApply(empId.intValue(),opinion.intValue());
    }

    @GetMapping("/position/change")
    public BasicResult getPositionChange(){
        return bossService.ListPositionChangeActivity();
    }

    @PostMapping("/position/change/{pcId}/{opinion}")
    public BasicResult permitPositionChange(@PathVariable("pcId") Long pcId,@PathVariable("opinion") Long opinion){
        return bossService.permitPositionChangeApply(pcId.intValue(),opinion.intValue());
    }
}
