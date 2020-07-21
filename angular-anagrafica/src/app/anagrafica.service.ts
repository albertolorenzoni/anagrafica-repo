import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

import { Person } from "./person";
import { Provincia } from "./provincia";
import { Comune } from "./comune";

@Injectable({
  providedIn: 'root'
})
export class AnagraficaService {

  private baseUrl = 'http://localhost:8090'

  constructor(private http: HttpClient) { }

  getPersonsList(): Observable<Person[]> {
    return this.http.get<Person[]>(`${this.baseUrl}/anagrafica`);
  }

  addPerson(person: Person): Observable<Object> {
    return this.http.post(`${this.baseUrl}/anagrafica`,person);
  }

  getProvince(): Observable<Provincia[]> {
    return this.http.get<Provincia[]>(`${this.baseUrl}/province`);
  }

  getComuni(provId: number): Observable<Comune[]> {
    return this.http.get<Comune[]>(`${this.baseUrl}/comuni/${provId}`);
  }

  getPerson(id: number): Observable<Person> {
    return this.http.get<Person>(`${this.baseUrl}/anagrafica/${id}`);
  }

  deletePerson(person: Person): Observable<Person> {
    return this.http.delete<Person>(`${this.baseUrl}/anagrafica/${person.idAnagrafica}`);
  }

  updatePerson(person: Person, id: number): Observable<Person> {
    return this.http.put<Person>(`${this.baseUrl}/anagrafica/${id}`, person);
  }
}
