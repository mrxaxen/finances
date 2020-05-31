import { Injectable } from '@angular/core';
import { Transaction } from './transaction';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({ 
    // 'Content-Type': 'application/json',
    // 'Authorization': '', // admin/password
  })
};

@Injectable({
  providedIn: 'root'
})
export class TransactionService {
  private transactionUrl = 'http://localhost:8080/transactions';
  /*transactions:Transaction[]=[
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
  ];*/

  constructor(
    private http: HttpClient
  ) { }

    
getTransactions(): Promise<Transaction[]> {
  return this.http.get<Transaction[]>(`${this.transactionUrl}`, httpOptions).toPromise();
}

getTransaction(id: number): Promise<Transaction> {
return this.http.get<Transaction>(`${this.transactionUrl}/${id}`, httpOptions).toPromise();
}

createTransaction(transaction: Transaction): Promise<Transaction> {
return this.http.post<Transaction>(`${this.transactionUrl}`, Transaction, httpOptions).toPromise();
}

updateTransaction(transaction: Transaction): Promise<Transaction> {
return this.http.put<Transaction>(`${this.transactionUrl}/${transaction.id}`, transaction, httpOptions).toPromise();
}

deleteTransaction(id): Promise<Transaction> {
return this.http.delete<Transaction>(`${this.transactionUrl}/${id}`, httpOptions).toPromise();
}

    
  /*
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
  }*/

}
