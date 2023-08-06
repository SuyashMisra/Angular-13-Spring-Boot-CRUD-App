import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeListComponent } from './features/components/employee-list/employee-list.component';
import { CreateEmployeeComponent } from './features/components/create-employee/create-employee.component';
import { UpdateEmployeeComponent } from './features/components/update-employee/update-employee.component';
import { EmployeeDetailsComponent } from './features/components/employee-details/employee-details.component';
import { PageNotFoundComponent } from './core/components/page-not-found/page-not-found.component';

const routes: Routes = [
  {path: '', redirectTo:'employees', pathMatch: 'full'},
  {path: 'employees', component: EmployeeListComponent},
  {path: 'create-employee', component: CreateEmployeeComponent},
  {path: 'update-employee/:id', component: UpdateEmployeeComponent},
  {path: 'employee-details/:id', component: EmployeeDetailsComponent},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
