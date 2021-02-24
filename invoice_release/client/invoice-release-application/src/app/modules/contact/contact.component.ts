import { Component, OnInit} from "@angular/core";

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.scss']
})
export class ContactComponent implements OnInit {

  id: number;
  name: String;

  constructor() { }

  ngOnInit() {
  }

  saveContact() {
    const contact = {id: this.id, name: this.name};

    console.log(contact);

  }
}
