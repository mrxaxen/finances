import { Transaction } from './transaction';

export class Report {

    id:number=0;
    year:number=0;
    month:number=0;
    numberOfTransactions:number=0;
    incomes:number=0;
    expenses:number=0;
    monthlyBalance:number=0;
    userId:number=0;
    //TODO: improve report class
    constructor(year:number,month:number,transactions:Transaction[]){
        transactions.forEach(function (transaction) {
            console.log(transaction);
          }); 
    }
}
