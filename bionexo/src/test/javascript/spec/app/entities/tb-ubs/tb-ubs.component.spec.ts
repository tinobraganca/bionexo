/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { BionexoTestModule } from '../../../test.module';
import { TB_UBSComponent } from 'app/entities/tb-ubs/tb-ubs.component';
import { TB_UBSService } from 'app/entities/tb-ubs/tb-ubs.service';
import { TB_UBS } from 'app/shared/model/tb-ubs.model';

describe('Component Tests', () => {
    describe('TB_UBS Management Component', () => {
        let comp: TB_UBSComponent;
        let fixture: ComponentFixture<TB_UBSComponent>;
        let service: TB_UBSService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [BionexoTestModule],
                declarations: [TB_UBSComponent],
                providers: []
            })
                .overrideTemplate(TB_UBSComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(TB_UBSComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(TB_UBSService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new TB_UBS(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.tB_UBS[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
