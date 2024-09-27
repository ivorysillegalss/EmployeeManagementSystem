package com.chenzc.employeemanagementsystem.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenzc.employeemanagementsystem.domain.*;
import com.chenzc.employeemanagementsystem.enums.RespEnums;
import com.chenzc.employeemanagementsystem.mapper.EventMapper;
import com.chenzc.employeemanagementsystem.mapper.PositionChangeMapper;
import com.chenzc.employeemanagementsystem.mapper.PurchaseMapper;
import com.chenzc.employeemanagementsystem.mapper.VacationMapper;
import com.chenzc.employeemanagementsystem.service.BossService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BossServiceImpl implements BossService {

    @Resource
    private PurchaseMapper purchaseMapper;

    @Resource
    private EventMapper eventMapper;

    @Resource
    private VacationMapper vacationMapper;

    @Resource
    private PositionChangeMapper positionChangeMapper;

    @Override
    public BasicResult showMeetingApplications() {
        List<Event> eventList = eventMapper.selectList(null);
        return BasicResult.success(RespEnums.SUCCESS, eventList);
    }

    @Override
    public BasicResult permitMeetingApply(int meetingId, int opinion) {
        QueryWrapper<Event> qw = new QueryWrapper<>();
        qw.eq("event_id", qw);
        List<Event> eventList = eventMapper.selectList(qw);
        if (Objects.isNull(eventList) || CollUtil.isEmpty(eventList)) {
            return BasicResult.fail();
        }
        eventList.getFirst().setStatus(opinion);
        return BasicResult.success();
    }

    @Override
    public BasicResult permitVacationApply(int empId, int opinion) {
        QueryWrapper<Vacation> qw = new QueryWrapper<>();
        qw.eq("empId", empId);
        List<Vacation> vacations = vacationMapper.selectList(qw);
        if (Objects.isNull(vacations) || CollUtil.isEmpty(vacations)) {
            return BasicResult.fail();
        }
        vacations.getFirst().setBossOpinion(opinion == 1 ? Boolean.TRUE : Boolean.FALSE);
        return BasicResult.success();
    }

    @Override
    public BasicResult permitPurchaseApply(int empId, int opinion) {
        QueryWrapper<Purchase> qw = new QueryWrapper<>();
        qw.eq("empId", empId);
        List<Purchase> vacations = purchaseMapper.selectList(qw);
        if (Objects.isNull(vacations) || CollUtil.isEmpty(vacations)) {
            return BasicResult.fail();
        }
        vacations.getFirst().setBossOpinion(opinion == 1 ? Boolean.TRUE : Boolean.FALSE);
        return BasicResult.success();
    }

    @Override
    public BasicResult permitPositionChangeApply(int positionChangeId, int opinion) {
        QueryWrapper<PositionChange> qw = new QueryWrapper<>();
        qw.eq("position_change_id", positionChangeId);
        List<PositionChange> vacations = positionChangeMapper.selectList(qw);
        if (Objects.isNull(vacations) || CollUtil.isEmpty(vacations)) {
            return BasicResult.fail();
        }
        vacations.getFirst().setStatus(opinion == 1 ? Boolean.TRUE : Boolean.FALSE);
        return BasicResult.success();
    }

    @Override
    public BasicResult ListPositionChangeActivity() {
        List<PositionChange> positionChanges = positionChangeMapper.selectList(null);
        if (Objects.isNull(positionChanges) || CollUtil.isEmpty(positionChanges)) {
            System.out.println("nil");
            return BasicResult.fail();
        }
        return BasicResult.success();
    }

}
