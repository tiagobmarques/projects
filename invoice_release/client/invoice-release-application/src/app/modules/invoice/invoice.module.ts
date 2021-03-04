import { InvoiceRoutingModule } from './invoice-routing.module';
import { InvoiceFormComponent } from './containers/invoice-form/invoice-form.component';
import { InvoiceListComponent } from './containers/invoice-list/invoice-list.component';
import { InvoiceContainerComponent } from './containers/invoice-container/invoice-container.component';
import { SharedModule } from './../../shared/shared.module';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from "@angular/common";

@NgModule({
  declarations: [
    InvoiceContainerComponent,
    InvoiceListComponent,
    InvoiceFormComponent],
  imports: [CommonModule, InvoiceRoutingModule, FormsModule, SharedModule]
})
export class InvoiceModule { }
