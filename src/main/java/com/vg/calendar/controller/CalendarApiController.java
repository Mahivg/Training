package com.vg.calendar.controller;

import com.vg.calendar.model.BaseResponse;
import com.vg.calendar.model.WeekDayData;
import com.vg.calendar.model.WeeklyRecordResponse;
import com.vg.calendar.util.CalendarUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1")
public class CalendarApiController {

    @GetMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getString(){
        return "mydata";
    }


    @GetMapping(value = "/getWeekRecord", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WeeklyRecordResponse> getWeekRecord(){
        WeeklyRecordResponse response = new WeeklyRecordResponse();
        List<WeekDayData> weekReport = CalendarUtils.getWeekDayData();
        response.setData(weekReport);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}


