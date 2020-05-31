import { Component, OnInit, Input } from '@angular/core';
import { Transaction } from '../transaction';

@Component({
  selector: 'transaction-form',
  templateUrl: './transaction-form.component.html',
  styleUrls: ['./transaction-form.component.css']
})
export class TransactionFormComponent implements OnInit {
  @Input() transaction:Transaction 
  constructor() { }

  ngOnInit(): void {
  }

}
