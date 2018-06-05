import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PocetnaComponent } from './pocetna/pocetna.component';
import { SearchResultsComponent } from './search-results/search-results.component';

const routes: Routes = [
    {path: 'pocetna', component: PocetnaComponent},
    {path: 'search', component: SearchResultsComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {}
export const routingComponents = [PocetnaComponent]
