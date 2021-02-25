import { ContactService } from '../../services/contact.service';
import { Component, OnInit} from "@angular/core";

@Component({
  selector: 'app-contact',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.scss']
})
export class ContactFormComponent implements OnInit {

  id: number;
  name: String;

  constructor(private service: ContactService) { }

  ngOnInit() {
  }

  saveContact() {
    /*const contact = {id: this.id, name: this.name};

    this.service.saveContact(contact).subscribe(result => {
      //Add more code here
    }, (error) => {
      console.error(error);

    });*/
  }
}
