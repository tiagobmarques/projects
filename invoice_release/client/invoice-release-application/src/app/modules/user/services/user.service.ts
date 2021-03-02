import { IUser } from './../models/user.interface';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userList: any[];
  private url = 'http://localhost:8080/v1/user';

  constructor(private httpClient: HttpClient) {
    this.userList = [];
  }

  getUserList(): Observable<IUser[]>{
    return this.httpClient.get<IUser[]>(this.url);
  }

  saveUser(user: IUser): Observable<IUser> {
    return this.httpClient.post<IUser>(this.url, user);
  }
}
