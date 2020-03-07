import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Employee } from 'src/app/employee.model';
import { EmployeeService } from 'src/app/employee.service';
import { Router } from '@angular/router';
import { error } from '@angular/compiler/src/util';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Observable<Employee[]>;

  // Inject employeeService and Router
  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit() {
    this.initData();
  }

  // Init data
  initData() {
    // Get all employees
    this.employeeService.getAllEmployees().subscribe(data => {
      // console.log(data);
      this.employees = data;
      // console.log(this.employees);
    },
    error => {
      console.log(error);
    })
  }

  // Delete employee
  onDelete(employeeId: number) {
    return this.employeeService.deleteEmployee(employeeId).subscribe(data => {
      this.initData();
      this.router.navigate(['employee'])
    },
    error => {
      console.log(error);
    });
  }

  // Update employee
  onUpdate(employeeId: number) {
    this.router.navigate(['update', employeeId]);
  }

  // Show employee details
  onShowDetails(employeeId: number) {
    this.router.navigate(['details', employeeId])
  }

}
