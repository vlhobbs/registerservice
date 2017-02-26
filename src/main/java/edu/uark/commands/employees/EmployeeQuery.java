package edu.uark.commands.employees;

import java.util.UUID;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.Employee;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeQuery implements ResultCommandInterface<Employee> {
	@Override
	public Employee execute() {
		return new Employee(
			this.employeeRepository.get(this.employeeId)
		);
	}

	//Properties
	private UUID employeeId;
	public UUID getEmployeeId() {
		return this.employeeId;
	}
	public EmployeeQuery setEmployeeId(UUID employeeId) {
		this.employeeId = employeeId;
		return this;
	}
	
	private EmployeeRepositoryInterface employeeRepository;
	public EmployeeRepositoryInterface getProductRepository() {
		return this.employeeRepository;
	}
	public EmployeeQuery setProductRepository(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
		return this;
	}
	
	public EmployeeQuery() {
		this.employeeRepository = new EmployeeRepository();
	}
}
