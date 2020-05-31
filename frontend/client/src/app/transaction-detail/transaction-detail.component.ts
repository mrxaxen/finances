import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Transaction } from '../transaction';
import {TransactionService} from '../transaction.service'

@Component({
  selector: 'transaction-detail',
  templateUrl: './transaction-detail.component.html',
  styleUrls: ['./transaction-detail.component.css']
})
export class TransactionDetailComponent implements OnInit {
  public transaction: Transaction = null;

  constructor(
    private route: ActivatedRoute,
    private transactionService: TransactionService
  ) { }

  public async ngOnInit(): Promise<void> {
    const id = +this.route.snapshot.paramMap.get('id');
    this.transaction = await this.transactionService.getTransaction(id);
  }
}
