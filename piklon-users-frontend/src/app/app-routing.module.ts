import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PocetnaComponent } from './pocetna/pocetna.component';
import { SearchResultsComponent } from './search-results/search-results.component';
import { ArticlePreviewComponent } from './article-preview/article-preview.component';
import { UserOfTheDayComponent } from './user-of-the-day/user-of-the-day.component';
import { UserProfileComponent } from './user-profile/user-profile.component';

const routes: Routes = [
    {path: 'pocetna', component: PocetnaComponent},
    {path: 'search', component: SearchResultsComponent},
    {path: 'article/:id', component: ArticlePreviewComponent},
    {path: 'user_of_the_day', component: UserOfTheDayComponent},
    {path: 'profile', component: UserProfileComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {}
export const routingComponents = [PocetnaComponent]
