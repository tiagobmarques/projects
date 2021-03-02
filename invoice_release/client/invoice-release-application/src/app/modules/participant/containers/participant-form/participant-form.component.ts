import { ParticipantService } from './../../services/participant.service';
import { Component, OnInit} from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: 'app-participant',
  templateUrl: './participant-form.component.html',
  styleUrls: ['./participant-form.component.scss']
})
export class ParticipantFormComponent implements OnInit {

  id: number;
  name: String;
  registrationType: String;
  registrationNumber: String;

  constructor(private service: ParticipantService, private router: Router) { }

  ngOnInit() {
  }

  saveParticipant() {
    const participant = {id: this.id, name: this.name, registrationType: this.registrationType, registrationNumber: this.registrationNumber};

    this.service.saveParticipant(participant).subscribe(result => {
      this.router.navigateByUrl("participant/list");
    }, (error) => {
      console.error(error);
    });
  }

  cancel() {
    this.router.navigateByUrl("participant/list");
  }
}
