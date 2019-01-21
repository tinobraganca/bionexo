/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { BionexoTestModule } from '../../../test.module';
import { TB_UBSDetailComponent } from 'app/entities/tb-ubs/tb-ubs-detail.component';
import { TB_UBS } from 'app/shared/model/tb-ubs.model';

describe('Component Tests', () => {
    describe('TB_UBS Management Detail Component', () => {
        let comp: TB_UBSDetailComponent;
        let fixture: ComponentFixture<TB_UBSDetailComponent>;
        const route = ({ data: of({ tB_UBS: new TB_UBS(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [BionexoTestModule],
                declarations: [TB_UBSDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(TB_UBSDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(TB_UBSDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.tB_UBS).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
