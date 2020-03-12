import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DisplayComponent } from './components/display-component/display-component.component';
import { EditComponent } from './components/edit/edit.component';


const routes: Routes = [
  { path: 'list', component: DisplayComponent },
  { path: 'edit', component: EditComponent },
  { path: '', redirectTo: 'list', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
