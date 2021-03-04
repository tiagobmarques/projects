import { InvoiceFormComponent } from './containers/invoice-form/invoice-form.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { InvoiceContainerComponent } from './containers/invoice-container/invoice-container.component';
import { InvoiceListComponent } from './containers/invoice-list/invoice-list.component';

const routes: Routes = [
  {
    path: '',
    component: InvoiceContainerComponent,
    children: [
      {
        path: 'list',
        component: InvoiceListComponent,
      },
      {
        path: 'form',
        children: [
          {
            path: '',
            component: InvoiceFormComponent,
            data: { disableClientSelect: true },
          },
          {
            path: ':id/edit',
            component: InvoiceFormComponent,
            data: { disableClientSelect: true },
          },
        ],
      }
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class InvoiceRoutingModule { }
