import { ContactService } from '../../services/contact.service';
import { Component, OnInit} from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: 'app-contact',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.scss']
})
export class ContactFormComponent implements OnInit {

  id: number;
  name: String;

  constructor(private service: ContactService, private router: Router) { }

  ngOnInit() {
  }

  saveContact() {
    const contact = {id: this.id, name: this.name};

    this.service.saveContact(contact).subscribe(result => {
      this.router.navigateByUrl("contact/list");
    }, (error) => {
      console.error(error);
    });
  }

  cancel() {
    this.router.navigateByUrl("contact/list");
  }
}
