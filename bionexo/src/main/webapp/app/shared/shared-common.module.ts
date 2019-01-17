import { NgModule } from '@angular/core';

import { BionexoSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [BionexoSharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [BionexoSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class BionexoSharedCommonModule {}
