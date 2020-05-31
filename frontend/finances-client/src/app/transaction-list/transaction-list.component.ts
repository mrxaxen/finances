import { Component } from '@angular/core';
import { Transaction } from '../transaction';
import { TransactionService } from '../transaction.service'

@Component({
  selector: 'transaction-list',
  templateUrl: './transaction-list.component.html',
  styleUrls: ['./transaction-list.component.css']
})
export class TransactionListComponent{
  private transactions:Transaction[]=[];
  constructor(
    private transactionService:TransactionService ){ 
      this.transactions = transactionService.getTransactions();
    };
}
