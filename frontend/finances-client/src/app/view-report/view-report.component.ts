import { Component } from '@angular/core';
import { Transaction } from '../transaction';
import { TransactionListComponent } from '../transaction-list/transaction-list.component';
import { Report } from '../report';

@Component({
  selector: 'view-report',
  templateUrl: './view-report.component.html',
  styleUrls: ['./view-report.component.css']
})
export class ViewReportComponent {
  //TODO: improve reports
  reports:Report[]=[
    {
      id:1,
      year:2020,
      month:5,
      numberOfTransactions:1,
      incomes:10000,
      expenses:1000,
      monthlyBalance:9000,
      userId:1,
    },
  ];

}
