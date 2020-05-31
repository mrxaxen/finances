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
  reports:Report[];
  constructor() {
    let transactions:TransactionListComponent=new TransactionListComponent();
    console.log(transactions);
   }

}
