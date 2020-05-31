import { Component, OnInit, OnChanges, Input, Output, EventEmitter  } from '@angular/core'; 
import { Transaction } from '../transaction';

@Component({
  selector: 'transaction-form',
  templateUrl: './transaction-form.component.html',
  styleUrls: ['./transaction-form.component.css']
})
export class TransactionFormComponent implements OnInit, OnChanges {
  @Input() transaction:Transaction 
  constructor() { }

  model:Transaction
  @Output() onSubmit = new EventEmitter<Transaction>();

  ngOnInit(): void {
  }

  //setting empty obj or the transaction object
  ngOnChanges() {
    this.model = Object.assign({}, this.transaction);
  }

  
  submit(form) {
    if (!form.valid) {
      return;
    }
    this.onSubmit.emit(this.model);
  }

}
