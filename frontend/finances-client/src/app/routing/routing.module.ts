import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router'; 
import { TransactionListComponent } from '../transaction-list/transaction-list.component';
import { AddTransactionComponent } from '../add-transaction/add-transaction.component';
import { ViewReportComponent } from '../view-report/view-report.component';
import { TransactionDetailsComponent } from '../transaction-details/transaction-details.component'
import { AuthGuard } from '../auth.guard';


const routes: Routes = [
  {
    path: '',
    redirectTo: '/transactions',
    pathMatch: 'full'
  },
  {
    path: 'transactions',
    component: TransactionListComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'add-transaction',
    component: AddTransactionComponent
  },
  {
    path: 'view-report',
    component: ViewReportComponent
  },
  {
    path: 'transactions/:id',
    component: TransactionDetailsComponent
  },
];


@NgModule({
  imports: [ RouterModule.forRoot(routes)  ],
  exports: [ RouterModule ],
  declarations: []
})
export class RoutingModule { }