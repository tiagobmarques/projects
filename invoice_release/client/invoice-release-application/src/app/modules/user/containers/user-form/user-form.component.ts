import { UserService } from './../../services/user.service';
import { Component, OnInit} from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.scss']
})
export class UserFormComponent implements OnInit {

  id: number;
  name: String;
  login: String;
  password: String;

  constructor(private service: UserService, private router: Router) { }

  ngOnInit() {
  }

  saveContact() {
    const user = {id: this.id, name: this.name, login: this.login, password: this.password};

    this.service.saveUser(user).subscribe(result => {
      this.router.navigateByUrl("user/list");
    }, (error) => {
      console.error(error);
    });
  }

  cancel() {
    this.router.navigateByUrl("user/list");
  }
}
