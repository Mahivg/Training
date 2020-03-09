package com.vg.calendar.model;

import java.util.List;

public class WeeklyRecordResponse extends BaseResponse {

    private List<WeekDayData> data;

    public WeeklyRecordResponse() {
    }

    public List<WeekDayData> getData() {
        return data;
    }

    public void setData(List<WeekDayData> data) {
        this.data = data;
    }
}
