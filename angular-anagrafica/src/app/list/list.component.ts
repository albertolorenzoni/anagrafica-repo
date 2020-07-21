import { Component, OnInit } from '@angular/core';


import { AnagraficaService } from "../anagrafica.service";
import { Person } from "../person";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  list: Person[]

  constructor(private anagraficaService: AnagraficaService) { }

  ngOnInit(): void {
    this.getList();
  }

  getList(): void {
    this.anagraficaService.getPersonsList()
      .subscribe(persons => this.list = persons,
        err => console.error('Observer got an error: ' + err),
        () => console.log('Observer got a complete notification'));
  }

  delete(person: Person): void {
    this.anagraficaService.deletePerson(person).subscribe();
    this.list = this.list.filter(p => p !== person);
  }

 

}
