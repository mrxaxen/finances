import { Component, OnInit } from '@angular/core';
import { Transaction } from '../transaction';
import { TransactionService } from '../transaction.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'transaction-list',
  templateUrl: './transaction-list.component.html',
  styleUrls: ['./transaction-list.component.css']
})
export class TransactionListComponent implements OnInit {
  public transactions: Transaction[] = [];
  public selectedTransaction: Transaction;
  public numberOfTransactions:number=0;
  public currentBudget:number=0;
  public object:Object=new Object;
  public latestId:number=0;

  constructor(
    private transactionService: TransactionService,
    public authService: AuthService
  ) {
  }

  public async ngOnInit(): Promise<void> {
    this.transactions = await this.transactionService.getTransactions();
    this.setCurrentBudget();
    this.setNumberOfTransactions();
    this.latestId=this.getLatestId();
  }

  public onSelectTransaction(issue: Transaction): void {
    this.selectedTransaction = issue;
  }

  public async onFormSubmit(transaction: Transaction): Promise<void> {
    if (transaction.id > 0) {
      await this.transactionService.updateTransaction(transaction);
      this.transactions = await this.transactionService.getTransactions();
    } else {
      this.latestId++;
      if(this.latestId==this.getLatestId()+1){
          transaction.id=this.latestId;
          transaction.creationDate=new Date();
          transaction.user=this.authService.user;
          console.log(transaction);
          await this.transactionService.createTransaction(transaction);
          this.transactions = await this.transactionService.getTransactions();
      }
    }
    this.setCurrentBudget();
    this.setNumberOfTransactions();
    this.selectedTransaction = null;
  }

  public onNewClick(): void {
    this.selectedTransaction = new Transaction();
  }

  public async onDeleteClick(id: number): Promise<void> {
    await this.transactionService.deleteTransaction(id);
    this.transactions = await this.transactionService.getTransactions();
    this.selectedTransaction=null;
    this.setCurrentBudget();
    this.setNumberOfTransactions();
    this.latestId=this.getLatestId();
  }

  public setNumberOfTransactions():void{
    this.numberOfTransactions= this.transactions.length;
  } 

  public setCurrentBudget():void{
    let sum=0;
    this.transactions.forEach(element => {
      sum+=element.change;
    });
    this.currentBudget= sum;
  }

  public getLatestId():number{
      return this.transactions[this.transactions.length-1].id;
  }
}
