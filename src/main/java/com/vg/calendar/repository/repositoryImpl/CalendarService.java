package com.vg.calendar.repository.repositoryImpl;

import com.vg.calendar.model.WeekDayData;
import com.vg.calendar.model.WeeklyRecordResponse;
import com.vg.calendar.repository.ICalendarService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CalendarService implements ICalendarService {

    private int[] weekIndex = { 0, 1, 2, 3, 4, 5, 6 };


    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yy, h:mm a", Locale.US);

    @Override
    public WeeklyRecordResponse getWeekRecord(boolean urlParamPresent) {

        WeeklyRecordResponse response = new WeeklyRecordResponse();

        List<WeekDayData> weekRecord = new ArrayList<>();

        //IntSteam.range
        Arrays.stream(weekIndex)
                .forEach(index -> {
                    LocalDateTime day = LocalDateTime.now().plusDays(index);
                    WeekDayData record = new WeekDayData();
                    record.setDay(String.valueOf(index).concat(".").concat(day.getDayOfWeek().name()));
                    record.setDateTime(day);
                    record.setUrlParamPresent(urlParamPresent);
                    weekRecord.add(record);
                });

        response.setData(weekRecord);
        return response;
    }

    @Override
    public WeeklyRecordResponse mapAndGetWeekRecord(String[] dates) {

        WeeklyRecordResponse response = new WeeklyRecordResponse();

        List<WeekDayData> weekRecord = new ArrayList<>();

        AtomicInteger index = new AtomicInteger();

        Arrays.stream(dates)
                .forEach(date -> {
                    WeekDayData dayData = new WeekDayData();
                    LocalDateTime dateTime = LocalDateTime.parse(date,formatter);
                    dayData.setDateTime(dateTime);
                    dayData.setDay(String.valueOf(index.getAndIncrement()).concat(".").concat(dateTime.getDayOfWeek().name()));
                    dayData.setUrlParamPresent(false);
                    weekRecord.add(dayData);
                });
        response.setData(weekRecord);
        return response;
    }
}
