import { UserFormComponent } from './containers/user-form/user-form.component';
import { UserListComponent } from './containers/user-list/user-list.component';
import { UserContainerComponent } from './containers/user-container/user-container.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    component: UserContainerComponent,
    children: [
      {
        path: 'list',
        component: UserListComponent,
      },
      {
        path: 'form',
        children: [
          {
            path: '',
            component: UserFormComponent,
            data: { disableClientSelect: true },
          },
          {
            path: ':id/edit',
            component: UserFormComponent,
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
export class UserRoutingModule { }
