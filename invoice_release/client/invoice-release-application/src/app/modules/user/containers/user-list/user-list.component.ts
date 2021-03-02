import { UserService } from './../../services/user.service';
import { IUser } from './../../models/user.interface';
import { Component, OnInit} from "@angular/core";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {

  userList: IUser[];

  constructor(private service: UserService) { }

  ngOnInit() {
    this.service.getUserList().subscribe((rows: IUser[]) => {
      this.userList = rows;
    });
  }
}
