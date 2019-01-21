/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { BionexoTestModule } from '../../../test.module';
import { TB_UBSDeleteDialogComponent } from 'app/entities/tb-ubs/tb-ubs-delete-dialog.component';
import { TB_UBSService } from 'app/entities/tb-ubs/tb-ubs.service';

describe('Component Tests', () => {
    describe('TB_UBS Management Delete Component', () => {
        let comp: TB_UBSDeleteDialogComponent;
        let fixture: ComponentFixture<TB_UBSDeleteDialogComponent>;
        let service: TB_UBSService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [BionexoTestModule],
                declarations: [TB_UBSDeleteDialogComponent]
            })
                .overrideTemplate(TB_UBSDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(TB_UBSDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(TB_UBSService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete', inject(
                [],
                fakeAsync(() => {
                    // GIVEN
                    spyOn(service, 'delete').and.returnValue(of({}));

                    // WHEN
                    comp.confirmDelete(123);
                    tick();

                    // THEN
                    expect(service.delete).toHaveBeenCalledWith(123);
                    expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                })
            ));
        });
    });
});
