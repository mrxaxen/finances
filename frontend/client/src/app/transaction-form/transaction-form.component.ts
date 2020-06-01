import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Transaction } from '../transaction';

@Component({
  selector: 'transaction-form',
  templateUrl: './transaction-form.component.html',
  styleUrls: ['./transaction-form.component.css']
})
export class TransactionFormComponent {
  @Input() transaction: Transaction;
  public model: Transaction;
  @Output() submit: EventEmitter<Transaction> = new EventEmitter<Transaction>();

  constructor() { }

  ngOnChanges(): void {
    this.model = Object.assign({}, this.transaction);
  }

  onSubmit(form): void {
    console.log(form);
    if (!form.valid) {
      return;
    }
    console.log(this.model);
    this.submit.emit(this.model);
  }

}
