import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subscription, BehaviorSubject } from 'rxjs';
import { map } from 'rxjs/operators';
import { WeekDayData } from '../model/WeekDayData';
import { WeeklyRecordResponse } from '../model/WeeklyRecordResponse';

@Injectable()
export class CalendarService {

    calendarSubscrption = new BehaviorSubject<boolean>(false);
    calendarSubscription$ = this.calendarSubscrption.asObservable();

    weekRecord: WeeklyRecordResponse;
    

    constructor(private httpClient: HttpClient){

    }

    getWeekRecord(): Observable<WeeklyRecordResponse> {
        return this.httpClient.get<WeeklyRecordResponse>('http://localhost:6060/v1/getWeekRecord?param=data')
        .pipe(map(response  => { 
            response.data = response.data.map(data => {
                data.dateTime = new Date(data.dateTime);
                return data;
            })
            return response;
        }));
    }

    postWeekRecord(requestObj: any): Observable<WeeklyRecordResponse> {
        return this.httpClient.post<WeeklyRecordResponse>('http://localhost:6060/v1/mapWeekRecord', requestObj)
        .pipe(map(response  => { 
            response.data = response.data.map(data => {
                data.dateTime = new Date(data.dateTime);
                return data;
            });
            return response;
        }));

    }

}