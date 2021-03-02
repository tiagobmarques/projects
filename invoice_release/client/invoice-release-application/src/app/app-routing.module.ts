import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'contact',
        loadChildren: () =>
          import('./modules/contact/contact.module').then(m => m.ContactModule),
      },
      {
        path: 'user',
        loadChildren: () =>
          import('./modules/user/user.module').then(m => m.UserModule),
      },
      {
        path: 'participant',
        loadChildren: () =>
          import('./modules/participant/participant.module').then(m => m.ParticipantModule),
      },
      {
        path: '**',
        redirectTo: '/contact/list',
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
