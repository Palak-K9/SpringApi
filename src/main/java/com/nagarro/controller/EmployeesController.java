package com.nagarro.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.entities.Employee;
import com.nagarro.repository.EmployeeRepository;

/**
 * Class containing methods for modification of Employee data
 * 
 * @author palakkharbanda
 *
 */
@RestController
@RequestMapping("/restapi")
public class EmployeesController {

	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * Method to get data of all employees
	 * 
	 * @return List of Employees
	 */
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	/**
	 * Method to get data of a particular employee(by using id)
	 * 
	 * @param id
	 * @return
	 * 
	 */
	@GetMapping(path = "/employees/{id}")
	public ResponseEntity<? extends Object> getEmployeeById(@PathVariable(name = "id") Long id) {
		Optional<Employee> employee = null;

		try {
			employee = employeeRepository.findById(id);

		} catch (Exception e) {
			return ResponseEntity.of(Optional.of(employee));
		}
		if (employee != null) {
			return ResponseEntity.ok().body(employee);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * Method to enter data of a new employee in the database
	 * 
	 * @param employee
	 * @return
	 */
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	/**
	 * Method to get data of a particular employee by id for modification of his/her
	 * data
	 * 
	 * @param id
	 * @param employeeDetails
	 * @return
	 */
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable(name = "id") Long id, @RequestBody Employee employeeDetails) {
		Employee existingEmployee = employeeRepository.getById(id);
		existingEmployee.setEmployeeName(employeeDetails.getEmployeeName());
		existingEmployee.setLocation(employeeDetails.getLocation());
		existingEmployee.setEmail(employeeDetails.getEmail());
		existingEmployee.setDob(employeeDetails.getDob());
		return employeeRepository.save(existingEmployee);
	}

	/**
	 * Method to delete a particular employee's data
	 * 
	 * @param id
	 * @return true if the delete operation is done successfully
	 */
	@DeleteMapping("/employees/{id}")
	public boolean deleteEmployee(@PathVariable(name = "id") Long id) {
		employeeRepository.deleteById(id);
		return true;
	}

}
