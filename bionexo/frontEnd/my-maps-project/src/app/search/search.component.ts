import { Component, OnInit, Output, EventEmitter, Input, OnChanges} from '@angular/core';
import { HttpRestService } from "../service/httprest.service"



@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
  providers: [HttpRestService]
})
export class SearchComponent implements OnInit {

  resposta:string = '';

  @Input() public markersRetorno: any = [];

  @Output() public latLng: EventEmitter<any> = new EventEmitter<any>();

  @Output() public latLngRepassado: EventEmitter<any> = new EventEmitter<any>();


  constructor(private httpRestService: HttpRestService) { }

  ngOnInit() {
    this.httpRestService.consultaLatLongApiGeo(this.resposta).subscribe();
  }

  ngOnChanges(){
    console.log("search :", this.markersRetorno);
  }
  public latLngListaRepasse(lista: any){
    console.log("search event: ", lista)
    this.latLngRepassado.emit(lista);
    console.log("search latLngListaRepasse: ", this.latLngListaRepasse)
  }
  public checaValor():void{
    console.log("search :", this.markersRetorno);
  }
 
  public atualizaResposta(resposta: Event): void {
    this.resposta = (<HTMLInputElement> resposta.target).value;
    if(this.resposta.length >= 5){
        this.httpRestService.consultaLatLongApiGeo(this.resposta).subscribe(
          (resposta: any) => {
            this.latLng.emit({
              "lat": resposta.lat,
              "lng": resposta.lng
            })
          }
        );
      }
    } 

}
