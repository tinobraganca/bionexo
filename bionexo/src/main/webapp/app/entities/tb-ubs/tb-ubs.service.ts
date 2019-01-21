import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ITB_UBS } from 'app/shared/model/tb-ubs.model';

type EntityResponseType = HttpResponse<ITB_UBS>;
type EntityArrayResponseType = HttpResponse<ITB_UBS[]>;

@Injectable({ providedIn: 'root' })
export class TB_UBSService {
    public resourceUrl = SERVER_API_URL + 'api/tb-ubs';

    constructor(private http: HttpClient) {}

    create(tB_UBS: ITB_UBS): Observable<EntityResponseType> {
        return this.http.post<ITB_UBS>(this.resourceUrl, tB_UBS, { observe: 'response' });
    }

    update(tB_UBS: ITB_UBS): Observable<EntityResponseType> {
        return this.http.put<ITB_UBS>(this.resourceUrl, tB_UBS, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<ITB_UBS>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<ITB_UBS[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
