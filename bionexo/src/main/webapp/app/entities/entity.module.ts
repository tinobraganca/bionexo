import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { BionexoTB_UBSModule } from './tb-ubs/tb-ubs.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        BionexoTB_UBSModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class BionexoEntityModule {}
