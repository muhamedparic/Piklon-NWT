import { NgModule } from '@angular/core';
import {Routes, RouterModule } from '@angular/router';
import { PocetnaComponent } from './pocetna/pocetna.component';

const routes: Routes = [
    {path: 'pocetna', component: PocetnaComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {}
export const routingComponents = [PocetnaComponent]