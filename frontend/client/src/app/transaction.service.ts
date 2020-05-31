import { Injectable } from '@angular/core';
import { Transaction } from './transaction';
import { HttpClient } from '@angular/common/http';
import { httpOptions } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {
  private transactionUrl = 'http://localhost:8080/transactions';

  constructor(
    private http: HttpClient
  ) { }

  public getTransactions(): Promise<Transaction[]> {
    return this.http.get<Transaction[]>(`${this.transactionUrl}`, httpOptions).toPromise();
  }

  public getTransaction(id: number): Promise<Transaction> {
    return this.http.get<Transaction>(`${this.transactionUrl}/${id}`, httpOptions).toPromise();
  }

  public createTransaction(transaction: Transaction): Promise<Transaction> {
    return this.http.post<Transaction>(`${this.transactionUrl}`, transaction, httpOptions).toPromise();
  }

  public updateTransaction(issue: Transaction): Promise<Transaction> {
    return this.http.put<Transaction>(`${this.transactionUrl}/${issue.id}`, issue, httpOptions).toPromise();
  }

  public deleteTransaction(id: number): Promise<Transaction> {
    return this.http.delete<Transaction>(`${this.transactionUrl}/${id}`, httpOptions).toPromise();
  }
  

}
