import { Component, OnInit } from '@angular/core';
import { TransactionService } from '../transaction.service';
import { Transaction } from '../transaction';
import { Statistic } from '../statistic';

@Component({
  selector: 'transaction-statistics',
  templateUrl: './transaction-statistics.component.html',
  styleUrls: ['./transaction-statistics.component.css']
})
export class TransactionStatisticsComponent implements OnInit{
  public transactions:Transaction[]=[];
  public statistics:Statistic[]=[];
  constructor(private transactionService: TransactionService){  }

  public async ngOnInit(): Promise<void> {
    this.transactions = await this.transactionService.getTransactions();
    this.createStatistics();
  }

  createStatistics(){
    this.transactions.forEach(element => {
      let elementYear=new Date(element.creationDate).getFullYear();
      let elementMonth=new Date(element.creationDate).getMonth();
      if(this.statistics.length==0){
        this.statistics.push(new Statistic(
          0,
          elementYear,
          elementMonth,
          1,
          element.change>0 ? element.change:0,
          element.change<0 ? element.change:0,
          element.change))
      }
      else{
        var l=false;
        this.statistics.forEach(statistic => {
          if(statistic.year==elementYear && statistic.month == elementMonth){
            l=true;
            statistic.numberOfTransactions++;
            statistic.incomes+=element.change>0 ? element.change:0;
            statistic.expenses+=element.change<0 ? element.change:0
            statistic.monthlyBalance+=element.change;
          }
        });
        if(!l){
          this.statistics.push(new Statistic(
            this.statistics[this.statistics.length-1].id+1,
            elementYear,
            elementMonth,
            1,
            element.change>0 ? element.change:0,
            element.change<0 ? element.change:0,
            element.change))
        }
        }
    });
  }

  

}
