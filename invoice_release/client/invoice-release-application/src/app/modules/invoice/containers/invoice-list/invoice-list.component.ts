import { InvoiceService } from './../../services/invoice.service';
import { IInvoice, IInvoiceList } from './../../models/invoice.interface';
import { Component, OnInit} from "@angular/core";

@Component({
  selector: 'app-invoice-list',
  templateUrl: './invoice-list.component.html',
  styleUrls: ['./invoice-list.component.scss']
})
export class InvoiceListComponent implements OnInit {

  invoiceList: IInvoiceList[];

  constructor(private service: InvoiceService) { }

  ngOnInit() {
    this.service.getInvoiceList().subscribe((rows: IInvoiceList[]) => {
      console.log(rows);

      this.invoiceList = rows;
    });
  }
}
