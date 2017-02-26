package edu.uark.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.commands.employees.ActiveEmployeeCountsQuery;
import edu.uark.commands.employees.EmployeeLoginCommand;
import edu.uark.commands.employees.EmployeeQuery;
import edu.uark.commands.employees.EmployeeSaveCommand;
import edu.uark.models.api.ActiveEmployeeCounts;
import edu.uark.models.api.Employee;
import edu.uark.models.api.EmployeeLogin;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeRestController {
	@RequestMapping(value = "/apiv0/{employeeId}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable UUID employeeId) {
		return (new EmployeeQuery()).
			setEmployeeId(employeeId).
			execute();
	}
	
	@RequestMapping(value = "/apiv0/activecounts", method = RequestMethod.GET)
	public ActiveEmployeeCounts getActiveEmployeeCounts() {
		return (new ActiveEmployeeCountsQuery()).execute();
	}

	@RequestMapping(value = "/apiv0/login", method = RequestMethod.PUT)
	public Employee employeeLogin(@RequestBody EmployeeLogin employeeLogin) {
		return (new EmployeeLoginCommand()).
			setEmployeeLogin(employeeLogin).
			execute();
	}

	@RequestMapping(value = "/apiv0/", method = RequestMethod.PUT)
	public Employee putEmployee(@RequestBody Employee employee) {
		return (new EmployeeSaveCommand()).
			setApiEmployee(employee).
			execute();
	}

	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "Successful test. (EmployeeRestController)";
	}
}
