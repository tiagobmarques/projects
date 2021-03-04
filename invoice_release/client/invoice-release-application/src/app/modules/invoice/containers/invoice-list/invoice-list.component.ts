import { InvoiceService } from './../../services/invoice.service';
import { IInvoice } from './../../models/invoice.interface';
import { Component, OnInit} from "@angular/core";

@Component({
  selector: 'app-invoice-list',
  templateUrl: './invoice-list.component.html',
  styleUrls: ['./invoice-list.component.scss']
})
export class InvoiceListComponent implements OnInit {

  invoiceList: IInvoice[];

  constructor(private service: InvoiceService) { }

  ngOnInit() {
    this.service.getInvoiceList().subscribe((rows: IInvoice[]) => {
      console.log(rows);

      this.invoiceList = rows;
    });
  }
}
