package com.bjit.training.jdbc;

import java.util.List;
import java.util.Random;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.bjit.training.jdbc.dao.EmployeeDAO;
import com.bjit.training.jdbc.model.Employee;

public class App {
	public static void main(String[] args) {
		// Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		// Get the EmployeeDAO Bean
		EmployeeDAO employeeDAO = ctx.getBean("employeeDAO", EmployeeDAO.class);

		// Run some tests for JDBC CRUD operations
		Employee emp = new Employee();
		int rand = new Random().nextInt(1000);
		emp.setId(rand);
		emp.setName("BJIT Limited");
		emp.setRole("Trainer");
		// Create
		employeeDAO.save(emp);
		// Read
		Employee emp1 = employeeDAO.getById(rand);
		System.out.println("Employee Retrieved::" + emp1);
		// Update
		emp.setRole("Sr. Trainer");
		employeeDAO.update(emp);
		// Get All
		List<Employee> empList = employeeDAO.getAll();
		System.out.println(empList);
		// Delete
		employeeDAO.deleteById(rand);
		// Close Spring Context
		ctx.close();
		System.out.println("DONE");
	}
}
