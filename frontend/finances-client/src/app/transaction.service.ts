import { Injectable } from '@angular/core';
import { Transaction } from './transaction';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

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

  constructor() { }
  
  getTransactions() :Transaction[] {
    return this.transactions;
  }
  
  getTransaction(id:number):Transaction {
    return this.transactions.find(i => i.id === id);
  }

  updateTransaction(updateTransaction:Transaction) :void{
    let transaction=this.getTransaction(updateTransaction.id);
    if(transaction){
      transaction.title=updateTransaction.title;
      transaction.change=updateTransaction.change;
      transaction.creationDate=updateTransaction.creationDate;
    }
  }

}
