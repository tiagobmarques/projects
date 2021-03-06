import { IInvoice, IInvoiceList } from './../models/invoice.interface';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InvoiceService {

  private invoiceList: any[];
  private url = 'http://localhost:8080/v1/invoice';

  constructor(private httpClient: HttpClient) {
    this.invoiceList = [];
  }

  getInvoiceList(): Observable<IInvoiceList[]>{
    return this.httpClient.get<IInvoiceList[]>(this.url);
  }

  saveInvoice(invoice: IInvoice): Observable<IInvoice> {
    console.log(invoice);

    return this.httpClient.post<IInvoice>(this.url, invoice);
  }
}
