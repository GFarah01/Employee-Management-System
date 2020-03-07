package com.example.javaSpringBackend;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.javaSpringBackend.model.Employee;
import com.example.javaSpringBackend.repository.repository.EmployeeRepository;

@SpringBootApplication
public class JavaSpringBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringBackendApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(EmployeeRepository employeeRepository) {
		return args -> { 
			
			// Employees
			Employee employee1 = new Employee("Amin", "York", "amin.york@gmail.com");
			Employee employee2 = new Employee("Inara", "Meyer", "inara.meyer@yahoo.fr");
			Employee employee3 = new Employee("Kaydee", "Wagner", "kaydee.wagner@gmail.com");
			Employee employee4 = new Employee("Abbie", "Tierney", "abbie.tierney@yahoo.fr");
			Employee employee5 = new Employee("Austen", "Coles", "austen.coles@gmail.com");
			
			// Save employees
			employeeRepository.save(employee1);
			employeeRepository.save(employee2);
			employeeRepository.save(employee3);
			employeeRepository.save(employee4);
			employeeRepository.save(employee5);
			
			// Output employees
			System.out.println("/*--- Employee Management System ---*/");
			for(Employee employee : employeeRepository.findAll()) {
				System.out.println("Name: " + employee.getFirstName() + " " + employee.getLastName() +
						", Email: " + employee.getEmailId());
			}
		};
	}

}
