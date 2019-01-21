import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { TB_UBS } from 'app/shared/model/tb-ubs.model';
import { TB_UBSService } from './tb-ubs.service';
import { TB_UBSComponent } from './tb-ubs.component';
import { TB_UBSDetailComponent } from './tb-ubs-detail.component';
import { TB_UBSUpdateComponent } from './tb-ubs-update.component';
import { TB_UBSDeletePopupComponent } from './tb-ubs-delete-dialog.component';
import { ITB_UBS } from 'app/shared/model/tb-ubs.model';

@Injectable({ providedIn: 'root' })
export class TB_UBSResolve implements Resolve<ITB_UBS> {
    constructor(private service: TB_UBSService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<TB_UBS> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<TB_UBS>) => response.ok),
                map((tB_UBS: HttpResponse<TB_UBS>) => tB_UBS.body)
            );
        }
        return of(new TB_UBS());
    }
}

export const tB_UBSRoute: Routes = [
    {
        path: 'tb-ubs',
        component: TB_UBSComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'TB_UBS'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'tb-ubs/:id/view',
        component: TB_UBSDetailComponent,
        resolve: {
            tB_UBS: TB_UBSResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'TB_UBS'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'tb-ubs/new',
        component: TB_UBSUpdateComponent,
        resolve: {
            tB_UBS: TB_UBSResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'TB_UBS'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'tb-ubs/:id/edit',
        component: TB_UBSUpdateComponent,
        resolve: {
            tB_UBS: TB_UBSResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'TB_UBS'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const tB_UBSPopupRoute: Routes = [
    {
        path: 'tb-ubs/:id/delete',
        component: TB_UBSDeletePopupComponent,
        resolve: {
            tB_UBS: TB_UBSResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'TB_UBS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
