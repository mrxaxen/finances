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
      transactionService.getTransactions().then((data)=>{
        this.transactions=data;
        console.log(data);      
      });
      
    };

  onSelectTransaction(transaction:Transaction){
    this.selectedTransaction=transaction;
  }
/*
  onFormSubmit(transaction: Transaction) {
    if (transaction.id > 0) {
      this.transactionService.updateTransaction(transaction);
    } 
    this.selectedTransaction = null;
  }*/
  
  onNewClick() {
    this.selectedTransaction = new Transaction();
  }

  public async onDeleteClick(id: number): Promise<void> {
    await this.transactionService.deleteTransaction(id);
    this.transactions = await this.transactionService.getTransactions();
    //this.filter();
  }

  public async onFormSubmit(transaction: Transaction): Promise<void> {
    if (transaction.id > 0) {
      await this.transactionService.updateTransaction(transaction);
      this.transactions = await this.transactionService.getTransactions();
    } else {
      await this.transactionService.createTransaction(transaction);
      this.transactions = await this.transactionService.getTransactions();
    }
    this.selectedTransaction = null;
  }
}
