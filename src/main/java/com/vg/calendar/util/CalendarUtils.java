package com.vg.calendar.util;

import com.vg.calendar.model.WeekDayData;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarUtils {

    public static List<WeekDayData> getWeekDayData(){

        List<WeekDayData> data = new ArrayList<>();
        data.add(new WeekDayData("0.Monday", false, LocalDateTime.now()));

        return data;
    }
}
