/* tslint:disable max-line-length */
import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { of } from 'rxjs';
import { take, map } from 'rxjs/operators';
import { TB_UBSService } from 'app/entities/tb-ubs/tb-ubs.service';
import { ITB_UBS, TB_UBS } from 'app/shared/model/tb-ubs.model';

describe('Service Tests', () => {
    describe('TB_UBS Service', () => {
        let injector: TestBed;
        let service: TB_UBSService;
        let httpMock: HttpTestingController;
        let elemDefault: ITB_UBS;
        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [HttpClientTestingModule]
            });
            injector = getTestBed();
            service = injector.get(TB_UBSService);
            httpMock = injector.get(HttpTestingController);

            elemDefault = new TB_UBS(
                0,
                'AAAAAAA',
                'AAAAAAA',
                0,
                0,
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA'
            );
        });

        describe('Service methods', async () => {
            it('should find an element', async () => {
                const returnedFromService = Object.assign({}, elemDefault);
                service
                    .find(123)
                    .pipe(take(1))
                    .subscribe(resp => expect(resp).toMatchObject({ body: elemDefault }));

                const req = httpMock.expectOne({ method: 'GET' });
                req.flush(JSON.stringify(returnedFromService));
            });

            it('should create a TB_UBS', async () => {
                const returnedFromService = Object.assign(
                    {
                        id: 0
                    },
                    elemDefault
                );
                const expected = Object.assign({}, returnedFromService);
                service
                    .create(new TB_UBS(null))
                    .pipe(take(1))
                    .subscribe(resp => expect(resp).toMatchObject({ body: expected }));
                const req = httpMock.expectOne({ method: 'POST' });
                req.flush(JSON.stringify(returnedFromService));
            });

            it('should update a TB_UBS', async () => {
                const returnedFromService = Object.assign(
                    {
                        co_latitude: 'BBBBBB',
                        co_longitute: 'BBBBBB',
                        co_municipio: 1,
                        co_cnes: 1,
                        no_estabelecimento: 'BBBBBB',
                        no_endereco: 'BBBBBB',
                        no_bairro: 'BBBBBB',
                        no_cidade: 'BBBBBB',
                        co_telefone: 'BBBBBB',
                        no_estrutra_fisica_ambiencia: 'BBBBBB',
                        no_adap_defic_fisic_idoso: 'BBBBBB',
                        no_equipamentos: 'BBBBBB',
                        no_medicamentos: 'BBBBBB'
                    },
                    elemDefault
                );

                const expected = Object.assign({}, returnedFromService);
                service
                    .update(expected)
                    .pipe(take(1))
                    .subscribe(resp => expect(resp).toMatchObject({ body: expected }));
                const req = httpMock.expectOne({ method: 'PUT' });
                req.flush(JSON.stringify(returnedFromService));
            });

            it('should return a list of TB_UBS', async () => {
                const returnedFromService = Object.assign(
                    {
                        co_latitude: 'BBBBBB',
                        co_longitute: 'BBBBBB',
                        co_municipio: 1,
                        co_cnes: 1,
                        no_estabelecimento: 'BBBBBB',
                        no_endereco: 'BBBBBB',
                        no_bairro: 'BBBBBB',
                        no_cidade: 'BBBBBB',
                        co_telefone: 'BBBBBB',
                        no_estrutra_fisica_ambiencia: 'BBBBBB',
                        no_adap_defic_fisic_idoso: 'BBBBBB',
                        no_equipamentos: 'BBBBBB',
                        no_medicamentos: 'BBBBBB'
                    },
                    elemDefault
                );
                const expected = Object.assign({}, returnedFromService);
                service
                    .query(expected)
                    .pipe(
                        take(1),
                        map(resp => resp.body)
                    )
                    .subscribe(body => expect(body).toContainEqual(expected));
                const req = httpMock.expectOne({ method: 'GET' });
                req.flush(JSON.stringify([returnedFromService]));
                httpMock.verify();
            });

            it('should delete a TB_UBS', async () => {
                const rxPromise = service.delete(123).subscribe(resp => expect(resp.ok));

                const req = httpMock.expectOne({ method: 'DELETE' });
                req.flush({ status: 200 });
            });
        });

        afterEach(() => {
            httpMock.verify();
        });
    });
});
