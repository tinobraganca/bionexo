import { Component, OnInit, Input } from '@angular/core';
import { MouseEvent, MarkerManager } from '@agm/core';
import { SearchComponent } from '../search/search.component'
import { HttpRestService } from '../service/httprest.service'
import { Marker } from '@agm/core/services/google-maps-types';
@Component({
  selector: 'app-painel',
  templateUrl: './painel.component.html',
  styleUrls: ['./painel.component.css'],
  providers: [HttpRestService]
})
export class PainelComponent implements OnInit {

  public markers: marker[] = [];
  constructor(private httpRestService: HttpRestService) { }
   
  public markersRetorno: any = [];

  ngOnInit() {
  }

   // google maps zoom level
   zoom: number = 10;
  
   // initial center position for the map
   
   lat: number = -22.9500614;
   lng: number = -43.3832891;
   
   public markerClick(event: any): void{
    console.log("markerCliker", event)
    this.lat = event.lat;
    this.lng = event.lng;
   }
   

   clickedMarker(lat: number, lng: number) {
     this.lat = lat;
     this.lng = lng;

     console.log(`clicked the marker: ${lat || lng}`)
   }
   
   //mapClicked($event: MouseEvent) {
     //this.markers.push({
       //lat: $event.coords.lat,
       //lng: $event.coords.lng,
       //draggable: true
     //});
   //}
   
   markerDragEnd(m: marker, $event: MouseEvent) {
     console.log('dragEnd', m, $event);
   }
   
  

   buscarUbsProximas(event: any){
     console.log("buscaUbs")
     console.log(event)
     
      this.httpRestService.consultaLatLongApi(event).subscribe((retorno:any) => {
        console.log("retornou na consulta :", retorno);
        this.markersRetorno = retorno;
        console.log("markersRetorno:", this.markersRetorno);
        console.log("retornou na consulta :", retorno.length);
        this.markers = [];
        for(let i = 0; i < retorno.length; i++){
          let markermontando: any = {
            "lat":retorno[i].geoCodeLat,
            "lng":retorno[i].geoCodeLong,
            "label":i,
            "draggable":true,
            "name":retorno[i].name,
            "click": false
          }
          //this.markersRetorno.push(markermontando);
          
          this.markers.push(markermontando);
          
      }
     });
     //
     //this.markers = this.markersRetorno;
   }
  
 }
 
 // just an interface for type safety.
 interface marker {
   lat: number;
   lng: number;
   label?: string;
   draggable: boolean;

}
