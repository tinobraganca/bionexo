import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ITB_UBS } from 'app/shared/model/tb-ubs.model';

@Component({
    selector: 'jhi-tb-ubs-detail',
    templateUrl: './tb-ubs-detail.component.html'
})
export class TB_UBSDetailComponent implements OnInit {
    tB_UBS: ITB_UBS;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ tB_UBS }) => {
            this.tB_UBS = tB_UBS;
        });
    }

    previousState() {
        window.history.back();
    }
}
