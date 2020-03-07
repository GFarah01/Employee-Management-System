import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { Employee } from 'src/app/employee.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  // API
  private API = "http://localhost:8080/api/employees";

  constructor(private http: HttpClient) { }

  // Get all employees
  getAllEmployees(): Observable<any> {
    return this.http.get(this.API);
  }

  // Get employee by id
  getEmployeeById(id: number): Observable<any> {
    return this.http.get(this.API + "/" + id);
  }

  // Add employee
  addEmployee(employee: Employee): Observable<any> {
    return this.http.post(this.API, employee);
  }

  // Update employee
  updateEmployee(id: number, employeeDetails: Employee): Observable<any> {
    return this.http.put(this.API + "/" + id, employeeDetails);
  }

  // Delete employee
  deleteEmployee(id: number):Observable<any> {
    return this.http.delete(this.API + "/" + id);
  }
}
