import { Component } from '@angular/core';
import { Transaction } from '../transaction';
import { TransactionService } from '../transaction.service'

@Component({
  selector: 'transaction-list',
  templateUrl: './transaction-list.component.html',
  styleUrls: ['./transaction-list.component.css']
})
export class TransactionListComponent{
  public transactions:Transaction[]=[];
  selectedTransaction: Transaction;

  constructor(
    private transactionService:TransactionService ){ 
      this.transactions = transactionService.getTransactions();
    };

  onSelectTransaction(transaction:Transaction){
    this.selectedTransaction=transaction;
  }
}
