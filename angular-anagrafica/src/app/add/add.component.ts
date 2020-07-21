import { Component, OnInit } from '@angular/core';

import { AnagraficaService } from "../anagrafica.service";
import { Provincia } from "../provincia";
import { Comune } from "../comune";
import { Person } from "../person";

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  submitted = false;

  province: Provincia[];
  comuni: Comune[];

  data = new Person('','','', null, 0, 0);

  constructor(
    private anagraficaService: AnagraficaService
    ) { }

  ngOnInit(): void {
    this.getProvince();
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

  onSubmit() { 
    this.submitted = true;
    this.anagraficaService.addPerson(this.data).subscribe();
    window.alert("Dati inseriti correttamente");
    this.data = new Person('','','', null, 0, 0);
  }

}
