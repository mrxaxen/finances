import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from '../auth.guard';
import { LoginFormComponent } from '../login-form/login-form.component';
import { TransactionDetailComponent } from '../transaction-detail/transaction-detail.component';
import { TransactionFormComponent } from '../transaction-form/transaction-form.component';
import { TransactionListComponent } from '../transaction-list/transaction-list.component';
import { TransactionStatisticsComponent } from '../transaction-statistics/transaction-statistics.component';

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
    path: 'transactions/new',
    component: TransactionFormComponent,
    canActivate: [ AuthGuard ],
    data: {
      roles: ['ROLE_ADMIN']
    }
  },
  {
    path: 'transactions/:id',
    component: TransactionDetailComponent
  },
  {
    path: 'login',
    component: LoginFormComponent
  },
  {
    path: 'statistics',
    component:TransactionStatisticsComponent
  }
];

@NgModule({
  declarations: [],
  imports: [ RouterModule.forRoot(routes)  ],
  exports: [ RouterModule ],
})
export class RoutingModule { }
