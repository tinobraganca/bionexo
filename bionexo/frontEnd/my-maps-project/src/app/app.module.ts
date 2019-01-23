import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NgModule, ApplicationRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
//import {HttpClientModule} from '@angular/common/http';
import { AgmCoreModule } from '@agm/core';
import { TopoComponent } from './topo/topo.component';
import { SearchComponent } from './search/search.component';
import { PainelComponent } from './painel/painel.component';
import { ListaComponent } from './lista/lista.component';
//import { HttpRestService } from './service/http-rest.service';

@NgModule({

  declarations: [
    AppComponent,
    TopoComponent,
    SearchComponent,
    PainelComponent,
    ListaComponent,
  ],
  imports: [
    BrowserModule,
    CommonModule,
    HttpModule,
    FormsModule,
     AgmCoreModule.forRoot({
        apiKey: 'AIzaSyDgI5bt8JkaHzdujo07Co-oL_biUotCVm8'
      })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
