import { Component, OnInit } from '@angular/core';
import { Transaction } from '../transaction';
import { TransactionService } from '../transaction.service'
import { ActivatedRoute, ParamMap } from "@angular/router";


@Component({
  selector: 'transaction-details',
  templateUrl: './transaction-details.component.html',
  styleUrls: ['./transaction-details.component.css']
})
export class TransactionDetailsComponent implements OnInit {

  transaction: Transaction = null;

  constructor(
    private route: ActivatedRoute,
    private transactionService: TransactionService
  ) { }
  
  ngOnInit() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.transaction = this.transactionService.getTransaction(id);
  }
}
