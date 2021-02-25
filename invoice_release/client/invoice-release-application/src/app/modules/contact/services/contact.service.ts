import { IContact } from './../models/contact.interface';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  private contactList: any[];
  private url = 'http://localhost:8080/v1/contact';

  constructor(private httpClient: HttpClient) {
    this.contactList = [];
  }

  getContactList(): Observable<IContact[]>{
    return this.httpClient.get<IContact[]>(this.url);
  }

  saveContact(contact: IContact): Observable<IContact> {
    return this.httpClient.post<IContact>(this.url, contact);
  }
}
