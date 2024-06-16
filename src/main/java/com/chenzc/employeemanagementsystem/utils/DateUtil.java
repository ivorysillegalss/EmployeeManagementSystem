package com.chenzc.employeemanagementsystem.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;

public class DateUtil {
    public static long getLastDayOfMonthTimestamp() {
        LocalDate currentDate = LocalDate.now();
        LocalDate lastDayOfMonth = currentDate.with(TemporalAdjusters.lastDayOfMonth());
        LocalDateTime endOfDay = lastDayOfMonth.atTime(0, 0, 0);
        return endOfDay.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
