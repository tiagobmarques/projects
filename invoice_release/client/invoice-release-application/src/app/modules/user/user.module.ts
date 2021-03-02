import { UserFormComponent } from './containers/user-form/user-form.component';
import { UserListComponent } from './containers/user-list/user-list.component';
import { UserContainerComponent } from './containers/user-container/user-container.component';
import { UserRoutingModule } from './user-routing.module';
import { SharedModule } from './../../shared/shared.module';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from "@angular/common";

@NgModule({
  declarations: [
    UserContainerComponent,
    UserListComponent,
    UserFormComponent],
  imports: [CommonModule, UserRoutingModule, FormsModule, SharedModule]
})
export class UserModule { }
