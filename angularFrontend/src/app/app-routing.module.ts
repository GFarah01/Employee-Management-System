import { NgModule } from '@angular/core';

import { Routes, RouterModule } from '@angular/router';
import { EmployeeListComponent } from 'src/app/employee-list/employee-list.component';
import { CreateEmployeeComponent } from 'src/app/create-employee/create-employee.component';
import { UpdateEmployeeComponent } from 'src/app/update-employee/update-employee.component';
import { EmployeeDetailsComponent } from 'src/app/employee-details/employee-details.component';

// Routes
const routes: Routes = [
    { path: "", redirectTo: "employees", pathMatch: "full" },
    { path: "employees", component: EmployeeListComponent },
    { path: "add", component: CreateEmployeeComponent },
    { path: "update/:id", component: UpdateEmployeeComponent },
    { path: "details/:id", component: EmployeeDetailsComponent },
    { path: "**", redirectTo: "employees" }
]

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }