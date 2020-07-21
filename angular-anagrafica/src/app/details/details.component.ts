import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import {Location} from '@angular/common'

import { Person } from "../person";
import { AnagraficaService } from "../anagrafica.service";
import { Provincia } from "../provincia";
import { Comune } from "../comune";

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  data: Person;
  province: Provincia[];
  comuni: Comune[];

  constructor(
    private route: ActivatedRoute,
    private anagraficaService: AnagraficaService,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.getData();
    this.getProvince();
    
  }
  ngAfterContentChecked(): void {
    this.getComuni(this.data.idProvincia);
  }

  getData(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.anagraficaService.getPerson(id)
      .subscribe(data => this.data = data);
  }

  updateData(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.anagraficaService.updatePerson(this.data, id)
      .subscribe();
    window.alert("Dati aggiornati");
    this.location.back();
  }

  getProvince(): void {
    this.anagraficaService.getProvince()
      .subscribe(province => this.province = province,
        err => console.error('Observer got an error: ' + err),
        () => console.log('Observer got a complete notification'));
  }

  getComuni(idProvincia: number): void {
    
    this.anagraficaService.getComuni(idProvincia)
      .subscribe(comuni => this.comuni = comuni,
        err => console.error('Observer got an error: ' + err),
        () => console.log('Observer got a complete notification'));
  }

}
