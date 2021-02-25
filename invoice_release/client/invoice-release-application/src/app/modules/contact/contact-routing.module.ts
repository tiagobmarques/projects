import { ContactFormComponent } from './containers/contact-form/contact-form.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ContactContainerComponent } from './containers/contact-container/contact-container.component';
import { ContactListComponent } from './containers/contact-list/contact-list.component';

const routes: Routes = [
  {
    path: '',
    component: ContactContainerComponent,
    children: [
      {
        path: 'list',
        component: ContactListComponent,
      },
      {
        path: 'form',
        children: [
          {
            path: '',
            component: ContactFormComponent,
            data: { disableClientSelect: true },
          },
          {
            path: ':id/edit',
            component: ContactFormComponent,
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
export class ContactRoutingModule { }
