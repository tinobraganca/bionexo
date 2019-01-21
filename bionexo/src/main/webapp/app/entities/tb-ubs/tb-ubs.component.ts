import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { ITB_UBS } from 'app/shared/model/tb-ubs.model';
import { Principal } from 'app/core';
import { TB_UBSService } from './tb-ubs.service';

@Component({
    selector: 'jhi-tb-ubs',
    templateUrl: './tb-ubs.component.html'
})
export class TB_UBSComponent implements OnInit, OnDestroy {
    tB_UBS: ITB_UBS[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private tB_UBSService: TB_UBSService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.tB_UBSService.query().subscribe(
            (res: HttpResponse<ITB_UBS[]>) => {
                this.tB_UBS = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInTB_UBS();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: ITB_UBS) {
        return item.id;
    }

    registerChangeInTB_UBS() {
        this.eventSubscriber = this.eventManager.subscribe('tB_UBSListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
