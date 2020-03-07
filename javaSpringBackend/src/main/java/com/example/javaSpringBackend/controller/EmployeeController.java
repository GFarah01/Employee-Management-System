package com.example.javaSpringBackend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.javaSpringBackend.exception.ResourceNotFoundException;
import com.example.javaSpringBackend.model.Employee;
import com.example.javaSpringBackend.repository.repository.EmployeeRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class EmployeeController {

	// Inject our EmployeeRepository
	@Autowired
	private EmployeeRepository employeeRepository;
	
	// Get all employee
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	// Get employee by id
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") long employeeId) 
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(()-> new ResourceNotFoundException("Employee bot found for this id: " + employeeId));
		
		return ResponseEntity.ok().body(employee);
	}
	
	// Add employee
	@PostMapping("/employees")
	public Employee addEmployee(@Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	// Update employee
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") long employeeId,
			@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		
		// Get the employee by id
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id:" + employeeId));
		
		// Update
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employee.getEmailId());
		
		// Save
		Employee updatedEmployee = employeeRepository.save(employee);
		
		return ResponseEntity.ok().body(updatedEmployee);
	}
	
	// Delete employee
	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") long employeeId) 
			throws ResourceNotFoundException {
		
		// Get employee by id
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id:" + employeeId));
		
		// Delete employee
		employeeRepository.delete(employee);

		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", true);
		return response;
	}
	
}
