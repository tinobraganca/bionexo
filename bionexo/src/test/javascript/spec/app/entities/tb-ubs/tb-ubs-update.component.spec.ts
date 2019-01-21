/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { BionexoTestModule } from '../../../test.module';
import { TB_UBSUpdateComponent } from 'app/entities/tb-ubs/tb-ubs-update.component';
import { TB_UBSService } from 'app/entities/tb-ubs/tb-ubs.service';
import { TB_UBS } from 'app/shared/model/tb-ubs.model';

describe('Component Tests', () => {
    describe('TB_UBS Management Update Component', () => {
        let comp: TB_UBSUpdateComponent;
        let fixture: ComponentFixture<TB_UBSUpdateComponent>;
        let service: TB_UBSService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [BionexoTestModule],
                declarations: [TB_UBSUpdateComponent]
            })
                .overrideTemplate(TB_UBSUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(TB_UBSUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(TB_UBSService);
        });

        describe('save', () => {
            it('Should call update service on save for existing entity', fakeAsync(() => {
                // GIVEN
                const entity = new TB_UBS(123);
                spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                comp.tB_UBS = entity;
                // WHEN
                comp.save();
                tick(); // simulate async

                // THEN
                expect(service.update).toHaveBeenCalledWith(entity);
                expect(comp.isSaving).toEqual(false);
            }));

            it('Should call create service on save for new entity', fakeAsync(() => {
                // GIVEN
                const entity = new TB_UBS();
                spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                comp.tB_UBS = entity;
                // WHEN
                comp.save();
                tick(); // simulate async

                // THEN
                expect(service.create).toHaveBeenCalledWith(entity);
                expect(comp.isSaving).toEqual(false);
            }));
        });
    });
});
