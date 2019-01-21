import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { BionexoSharedModule } from 'app/shared';
import {
    TB_UBSComponent,
    TB_UBSDetailComponent,
    TB_UBSUpdateComponent,
    TB_UBSDeletePopupComponent,
    TB_UBSDeleteDialogComponent,
    tB_UBSRoute,
    tB_UBSPopupRoute
} from './';

const ENTITY_STATES = [...tB_UBSRoute, ...tB_UBSPopupRoute];

@NgModule({
    imports: [BionexoSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [TB_UBSComponent, TB_UBSDetailComponent, TB_UBSUpdateComponent, TB_UBSDeleteDialogComponent, TB_UBSDeletePopupComponent],
    entryComponents: [TB_UBSComponent, TB_UBSUpdateComponent, TB_UBSDeleteDialogComponent, TB_UBSDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class BionexoTB_UBSModule {}
