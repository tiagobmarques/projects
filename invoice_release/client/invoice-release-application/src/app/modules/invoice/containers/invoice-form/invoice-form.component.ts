import { IParticipant } from './../../../participant/models/participant.interface';
import { InvoiceService } from './../../services/invoice.service';
import { Component, OnInit} from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: 'app-invoice',
  templateUrl: './invoice-form.component.html',
  styleUrls: ['./invoice-form.component.scss']
})
export class InvoiceFormComponent implements OnInit {

  id: number;
  installmentDate: Date;
  document: String;
  participant: IParticipant;
  value: number;

  constructor(private service: InvoiceService, private router: Router) {
    this.participant = {id: 1, name: '', registrationType: 'CPF', registrationNumber: '06606787998'};
   }

  ngOnInit() {
  }

  saveInvoice() {
    const participant1 : IParticipant = {id: 1, name: 'Tete', registrationType: 'CPF', registrationNumber: '32165498712'};

    const invoice = {id: this.id, installmentDate: this.installmentDate, document: this.document,
                     participant: this.participant, value: this.value};

    this.service.saveInvoice(invoice).subscribe(result => {
      this.router.navigateByUrl("invoice/list");
    }, (error) => {
      console.error(error);
    });
  }

  cancel() {
    this.router.navigateByUrl("contact/list");
  }
}
