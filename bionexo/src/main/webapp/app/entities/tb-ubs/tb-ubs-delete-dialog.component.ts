import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ITB_UBS } from 'app/shared/model/tb-ubs.model';
import { TB_UBSService } from './tb-ubs.service';

@Component({
    selector: 'jhi-tb-ubs-delete-dialog',
    templateUrl: './tb-ubs-delete-dialog.component.html'
})
export class TB_UBSDeleteDialogComponent {
    tB_UBS: ITB_UBS;

    constructor(private tB_UBSService: TB_UBSService, public activeModal: NgbActiveModal, private eventManager: JhiEventManager) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.tB_UBSService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'tB_UBSListModification',
                content: 'Deleted an tB_UBS'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-tb-ubs-delete-popup',
    template: ''
})
export class TB_UBSDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ tB_UBS }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(TB_UBSDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
                this.ngbModalRef.componentInstance.tB_UBS = tB_UBS;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
                        this.ngbModalRef = null;
                    }
                );
            }, 0);
        });
    }

    ngOnDestroy() {
        this.ngbModalRef = null;
    }
}
