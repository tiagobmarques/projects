import { SharedModule } from './../../shared/shared.module';
import { ContactFormComponent } from './containers/contact-form/contact-form.component';
import { FormsModule } from '@angular/forms';
import { ContactListComponent } from './containers/contact-list/contact-list.component';
import { ContactRoutingModule } from './contact-routing.module';
import { NgModule } from '@angular/core';
import { ContactContainerComponent } from './containers/contact-container/contact-container.component';
import { CommonModule } from "@angular/common";
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    ContactContainerComponent,
    ContactListComponent,
    ContactFormComponent],
  imports: [CommonModule, ContactRoutingModule, FormsModule, SharedModule]
})
export class ContactModule { }
