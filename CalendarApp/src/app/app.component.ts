import { Component, OnInit } from '@angular/core';
import { CalendarService } from './services/calendar.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'CalendarApp';

  constructor(private calendarService: CalendarService){
    
  }

  ngOnInit(){
    this.calendarService.getWeekRecord().subscribe(res => {
      this.calendarService.weekRecord = res;
      this.calendarService.calendarSubscrption.next(true);
    });
  }

}
