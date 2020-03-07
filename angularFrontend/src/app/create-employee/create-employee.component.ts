import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/employee.model';
import { NgForm } from '@angular/forms';
import { EmployeeService } from 'src/app/employee.service';
import { Router } from '@angular/router';
import { error } from 'util';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee: Employee = new Employee();
  submitted: boolean = false;

  // Inject employeeService and Router
  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit() { }

  // Add employee
  addEmployee() {
    this.employeeService.addEmployee(this.employee).subscribe(data => {
      // console.log(data);
    },
    error => {
      console.log(error);
    })
  }

  onSubmit(addEmployeeForm: NgForm) {
    // console.log(addEmployeeForm)
    this.submitted = true;
    this.addEmployee();
    
    setTimeout(() => {
      this.router.navigate(['/employees']);
    }, 1000);
    
  }

}
