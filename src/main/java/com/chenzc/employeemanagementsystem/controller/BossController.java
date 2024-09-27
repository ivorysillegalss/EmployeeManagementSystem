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
}
