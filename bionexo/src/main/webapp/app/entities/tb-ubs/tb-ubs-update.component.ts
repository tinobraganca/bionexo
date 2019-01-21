import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { ITB_UBS } from 'app/shared/model/tb-ubs.model';
import { TB_UBSService } from './tb-ubs.service';

@Component({
    selector: 'jhi-tb-ubs-update',
    templateUrl: './tb-ubs-update.component.html'
})
export class TB_UBSUpdateComponent implements OnInit {
    tB_UBS: ITB_UBS;
    isSaving: boolean;

    constructor(private tB_UBSService: TB_UBSService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ tB_UBS }) => {
            this.tB_UBS = tB_UBS;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.tB_UBS.id !== undefined) {
            this.subscribeToSaveResponse(this.tB_UBSService.update(this.tB_UBS));
        } else {
            this.subscribeToSaveResponse(this.tB_UBSService.create(this.tB_UBS));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<ITB_UBS>>) {
        result.subscribe((res: HttpResponse<ITB_UBS>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
}
