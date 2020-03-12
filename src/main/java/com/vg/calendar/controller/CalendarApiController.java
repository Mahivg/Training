package com.vg.calendar.controller;

import com.vg.calendar.model.BaseResponse;
import com.vg.calendar.model.WeekDayData;
import com.vg.calendar.model.WeeklyRecordResponse;
import com.vg.calendar.repository.ICalendarService;
import com.vg.calendar.util.CalendarUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1")
@CrossOrigin(origins = "http://localhost:4200")
public class CalendarApiController {

    @Autowired
    private ICalendarService calendarService;

    @GetMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getString(){
        return "mydata";
    }


    @GetMapping(value = "/getWeekRecord", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WeeklyRecordResponse> weekday(@RequestParam Optional<String> param) {
        WeeklyRecordResponse response = calendarService.getWeekRecord(param.isPresent());
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping(value = "/mapWeekRecord", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WeeklyRecordResponse> weekday(@RequestBody String[] data){

        System.out.println(data);
        WeeklyRecordResponse response = calendarService.mapAndGetWeekRecord(data);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
}


