package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Employee;
import com.example.dao.EmployeeDAO;

@RestController
public class EmployeeController {

	@Autowired EmployeeDAO eDAO;
	
	@GetMapping("/employees")
	public List<Employee> getEmployee(){
		return eDAO.getAll();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable("id") int id) {
		return eDAO.getById(id);
	}
	
	@PostMapping("/employees")
	public String saveEmployee(@RequestBody Employee employee) {
		return eDAO.save(employee) + " NO. of rows saved to the database";
	}
	
	@PutMapping("/employees/{id}")
	public String updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
		return eDAO.update(employee,id) + " NO. of rows saved to the database";
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return eDAO.delete(id) + " NO. of rows saved to the database";
	}
}
