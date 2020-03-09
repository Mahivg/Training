package com.vg.calendar.model;

import java.time.LocalDate;

public class WeekDayData {

    private String day;

    private boolean urlParamPresent;

    private LocalDate dateTime;

    public WeekDayData() {
    }

    public WeekDayData(String day, boolean urlParamPresent, LocalDate dateTime) {
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

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
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


