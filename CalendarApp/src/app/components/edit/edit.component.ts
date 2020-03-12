import { Component, OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { CalendarService } from 'src/app/services/calendar.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.scss']
})
export class EditComponent implements OnInit {

  private myDates: any[];

  constructor(private calendarService: CalendarService, private router: Router) { }

  ngOnInit() {
    this.myDates = [
      {
        name: 'Input 0',
        dateTime: ""
      },
      {
        name: 'Input 1',
        dateTime: ""
      },
      {
        name: 'Input 2',
        dateTime: ""
      },
      {
        name: 'Input 3',
        dateTime: ""
      },
      {
        name: 'Input 4',
        dateTime: ""
      },
      {
        name: 'Input 5',
        dateTime: ""
      },
      {
        name: 'Input 6',
        dateTime: ""
      },
    ]
  }

  postData(): void {

    let datePipe = new DatePipe('en-US');

    console.log(this.myDates);

    const request = this.myDates.map( date =>  datePipe.transform(date.dateTime, 'short'));

    this.calendarService.postWeekRecord(request).subscribe(res => {
      this.calendarService.weekRecord = res;
      this.calendarService.calendarSubscrption.next(true);
      this.router.navigateByUrl('/list');
    });



  }

}
