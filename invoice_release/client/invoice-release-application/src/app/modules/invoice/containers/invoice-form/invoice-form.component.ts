import { IInvoice } from './../../models/invoice.interface';
import { ParticipantService } from './../../../participant/services/participant.service';
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
  participantId: number;
  value: number;

  participantList : IParticipant[];

  constructor(private service: InvoiceService, private participantService: ParticipantService, private router: Router) {
    //this.participant = {id: 1, name: '', registrationType: 'CPF', registrationNumber: '06606787998'};
   }

  ngOnInit() {
    this.participantService.getParticipantList().subscribe((rows: IParticipant[]) => {
      console.log(rows);

      this.participantList = rows;
    });
  }

  teste(elemento) {
    console.log(elemento);

  }

  saveInvoice() {

    console.log(this.participantId);

    const invoice :IInvoice = {id: this.id, installmentDate: this.installmentDate, document: this.document,
                     participantId: this.participantId, value: this.value};

    this.service.saveInvoice(invoice).subscribe(result => {
      this.router.navigateByUrl("invoice/list");
    }, (error) => {
      console.error(error);
    });
  }

  cancel() {
    this.router.navigateByUrl("invoie/list");
  }
}
