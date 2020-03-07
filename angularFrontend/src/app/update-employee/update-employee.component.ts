import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/employee.model';
import { NgForm } from '@angular/forms';
import { EmployeeService } from 'src/app/employee.service';
import { ActivatedRoute, Router } from '@angular/router';
import { error } from '@angular/compiler/src/util';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  id: number;
  employee: Employee;

  // Inject employeeService, Router and activatedRoute
  constructor(
    private employeeService: EmployeeService, 
    private activatedRoute: ActivatedRoute,
    private route: Router
  ) { }

  ngOnInit() {
    this.employee = new Employee();
    // Get the id
    this.id = this.activatedRoute.snapshot.params['id'];

    // Get the employee by id
    this.employeeService.getEmployeeById(this.id).subscribe(data => {
      // console.log(data)
      this.employee = data;
      // console.log(this.employee);
    },
    error => {
      console.log(error);
    })
  }

  // Update employee
  updateEmployee() {
    this.employeeService.updateEmployee(this.id, this.employee).subscribe(data => {
      // console.log(data);
      this.route.navigate(["/employees"])
    },
    error => {
      console.log(error);
    })
  }

  onSubmit(updateEmployeeForm: NgForm) {
    // console.log(updateEmployeeForm)
    this.updateEmployee();
  }
}
