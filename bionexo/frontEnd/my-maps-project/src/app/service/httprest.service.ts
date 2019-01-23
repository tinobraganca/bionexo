
import { Http } from "@angular/http"
//import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { map } from "rxjs/operators";
import { Injectable } from "@angular/core";


@Injectable()
export class HttpRestService {

    private pathGeoLocation: string = "https://maps.googleapis.com/maps/api/geocode/json?address=";
    private keyGeoLocation: string = "&key=AIzaSyDgI5bt8JkaHzdujo07Co-oL_biUotCVm8";
    private pathApi: string = "http://localhost:8080/api/tb-ubs-range";

    

    constructor(private http: Http){}

    //public consultaLatLongApiGeo(address: string): Promise<any> {
      //  return this.http.get(this.pathGeoLocation + JSON.stringify(address) + this.keyGeoLocation).toPromise().then(data => console.log(data)
        //).catch(err => {
          //  return Promise.reject(err.error || 'Server error');
        //});
    //}   

    
    public consultaLatLongBanco(lat: number, lng: number): Promise<any> {
        console.log("lat:", lat);
        console.log("lng:", lng);
        return new Promise(function(resolve, reject) {
            setTimeout(resolve, 10000, 'foo');
          });
    }   
    public consultaLatLongApiGeo(address: string): Observable<Object> {
        return this.http.get(this.pathGeoLocation + JSON.stringify(address) + this.keyGeoLocation).pipe(map((resposta) => {
            console.log(resposta.json());
            if("ZERO_RESULTS" !== resposta.json().status){
                let lat = resposta.json().results[0].geometry.location.lat
                let lng = resposta.json().results[0].geometry.location.lng
                return {
                    "lng":lng,
                    "lat":lat
                }
            }
        })); 
    }

    public consultaLatLongApi(latLong: any): Observable<any> {
        console.log(latLong);
        return this.http.get(this.pathApi + "?latitude=" + latLong.lat + "&longitude=" + latLong.lng).pipe(map((resposta) => {
            return resposta.json();
            
        })); 
    }
    
  }