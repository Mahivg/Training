package com.vg.calendar.repository;

import com.vg.calendar.model.WeeklyRecordResponse;

public interface ICalendarService {

    WeeklyRecordResponse getWeekRecord(boolean urlParamPresent);

    WeeklyRecordResponse mapAndGetWeekRecord(String[] dates);


}
