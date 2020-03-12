package com.vg.calendar.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vg.calendar.util.serializer.LocalDateTimeDeSerializer;
import com.vg.calendar.util.serializer.LocalDateTimeSerializer;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeekDayData {

    private String day;

    private boolean urlParamPresent;



    @JsonDeserialize(using = LocalDateTimeDeSerializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dateTime;

    public WeekDayData() {
    }

    public WeekDayData(String day, boolean urlParamPresent, LocalDateTime dateTime) {
        this.day = day;
        this.urlParamPresent = urlParamPresent;
        this.dateTime = dateTime;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public boolean isUrlParamPresent() {
        return urlParamPresent;
    }

    public void setUrlParamPresent(boolean urlParamPresent) {
        this.urlParamPresent = urlParamPresent;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "WeekDayData{" +
                "day='" + day + '\'' +
                ", urlParamPresent=" + urlParamPresent +
                ", dateTime=" + dateTime +
                '}';
    }

}


