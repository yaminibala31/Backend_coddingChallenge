import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SearchComponent } from './components/search/search.component';
import { DispalyComponent } from './components/dispaly/dispaly.component';
import { AddPlayerComponent } from './components/add-player/add-player.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { UpdateComponent } from './components/update/update.component';

const routes: Routes = [
    {path:'home',component:DashboardComponent},
    {path:'addPlayer',component:AddPlayerComponent},
    {path:'updatePlayer',component:UpdateComponent},
    {path:'displayall',component:DispalyComponent},
    {path:'search/:input',component:SearchComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
