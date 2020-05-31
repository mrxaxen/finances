import { Component } from '@angular/core';
import { Transaction } from '../transaction';

@Component({
  selector: 'transaction-list',
  templateUrl: './transaction-list.component.html',
  styleUrls: ['./transaction-list.component.css']
})
export class TransactionListComponent{
  transactions:Transaction[]=[
    {
      id:1,
      title:'Bills',
      change:-1000,
      creationDate:'2020.01.22',
    },
    {
      id:2,
      title:'Salary',
      change:10000,
      creationDate:'2020.01.22',
    },
  ];
}
