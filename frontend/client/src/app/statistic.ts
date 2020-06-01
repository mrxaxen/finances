export class Statistic {
    id:number;
    year:number;
    month:number;
    numberOfTransactions:number;
    incomes:number;
    expenses:number;
    monthlyBalance:number;

    constructor(id,year,month,numberOfTransactions,incomes,expenses,monthlyBalance){
        this.id=id;
        this.year=year;
        this.month=month;
        this.numberOfTransactions=numberOfTransactions;
        this.incomes=incomes;
        this.expenses=expenses;
        this.monthlyBalance=monthlyBalance;
    }
}
