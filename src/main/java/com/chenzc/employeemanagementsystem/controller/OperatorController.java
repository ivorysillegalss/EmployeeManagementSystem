package com.chenzc.employeemanagementsystem.controller;

import com.chenzc.employeemanagementsystem.domain.BasicResult;
import com.chenzc.employeemanagementsystem.dto.OperatorDTO;
import com.chenzc.employeemanagementsystem.service.OperatorService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operator")
public class OperatorController {

    @Resource
    private OperatorService operatorService;

    @GetMapping("/init")
    public BasicResult getOperationLog() {
        return operatorService.showOperationLog();
    }

    @GetMapping("/init/{id}")
    public BasicResult getOperationLog(@PathVariable("id") Long id) {
        return operatorService.showOperationLog(id);
    }

    @PostMapping("/modify/{operatorId}/user/{userId}")
    public BasicResult modifyPermission(@PathVariable("operatorId") Long operatorId, @PathVariable("userId") Long userId, @RequestBody OperatorDTO operatorDTO) {
        return operatorService.modifyPermission(operatorId, userId, operatorDTO.getNewRole());
    }

    @PostMapping("/insert/{operatorId}")
    public BasicResult insertNewOperator(@PathVariable("operatorId") Long operatorId, @RequestBody OperatorDTO operatorDTO) {
        return operatorService.insertNewOperator(operatorId, operatorDTO.getOperator(), operatorDTO.getUser());
    }
}
