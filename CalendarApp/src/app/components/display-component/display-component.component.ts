import { Component, OnInit } from '@angular/core';
import { CalendarService } from 'src/app/services/calendar.service';
import { WeekDayData } from 'src/app/model/WeekDayData'; 
import { Router } from '@angular/router';

@Component({
  selector: 'app-display-component',
  templateUrl: './display-component.component.html',
  styleUrls: ['./display-component.component.scss']
})
export class DisplayComponent implements OnInit {

  records: WeekDayData[];
  selectedRecord: WeekDayData = new WeekDayData();

  constructor(private calendarService: CalendarService, private router: Router) { }

  ngOnInit() {

    this.calendarService.calendarSubscription$.subscribe(flag => {
      if(flag){
        this.records = this.calendarService.weekRecord.data;
      }
    }); 
  }

  showAlert(record: WeekDayData): void {
    this.selectedRecord = record;     
  }

  goToEdit(): void {
    this.router.navigateByUrl('/edit');
  }

}
