import { Component, OnInit , Input, OnChanges, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent implements OnInit {
  @Input() public markersRetorno: any = [];

  @Output() public latLngLista: EventEmitter<any> = new EventEmitter<any>();
  
  constructor() { }

 
  public recuperaLocal(lat:number, lng: number):void{
    this.latLngLista.emit({
      "lat": lat,
      "lng": lng
    })
    console.log(event)
  }

  public checaValor():void{
  }

  ngOnInit() {
  }

  ngOnChanges(){
    console.log("listaa :",this.markersRetorno);
  }

}
