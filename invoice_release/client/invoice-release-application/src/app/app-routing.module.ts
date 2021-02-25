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
        path: '**',
        redirectTo: '/contact',
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
