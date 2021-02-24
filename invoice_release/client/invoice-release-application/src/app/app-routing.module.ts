import { UserComponent } from './modules/user/user.component';
import { ContactComponent } from './modules/contact/contact.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {path: '', redirectTo: 'contact', pathMatch: 'full'},
  {path: 'contact', component: ContactComponent},
  {path: 'user', component: UserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
