import { Component, OnInit } from '@angular/core';
import { EmployeeService } from 'src/app/employee.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Employee } from 'src/app/employee.model';
import { error } from 'util';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {

  id: number;
  employee: Employee;

  // Inject employeeService, Router and activatedRoute
  constructor(
    private employeeService: EmployeeService, 
    private router: Router, 
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit() {
    this.employee = new Employee();
    // Get the id
    this.id = this.activatedRoute.snapshot.params['id'];

    // get the employee y id
    this.employeeService.getEmployeeById(this.id).subscribe(data => {
      // console.log(data);
      this.employee = data;
      // console.log(this.employee);
    },error => {
      console.log(error);
    })
  }

  // Navigate back to employees list
  goTolist() {
    this.router.navigate(['/emploeyees']);
  }

}
