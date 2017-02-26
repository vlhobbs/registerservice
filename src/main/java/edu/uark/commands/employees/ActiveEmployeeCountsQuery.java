package edu.uark.commands.employees;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.ActiveEmployeeCounts;
import edu.uark.models.enums.EmployeeClassification;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class ActiveEmployeeCountsQuery implements ResultCommandInterface<ActiveEmployeeCounts> {
	@Override
	public ActiveEmployeeCounts execute() {
		//Generally it would be better to run a single query, probably using a GROUP BY clause, to count all records by classification.
		return (new ActiveEmployeeCounts()).
			setActiveCashierCount(
				this.employeeRepository.activeCountByClassification(EmployeeClassification.CASHIER)
			).
			setActiveShiftManagerCount(
				this.employeeRepository.activeCountByClassification(EmployeeClassification.SHIFT_MANAGER)
			).
			setActiveGeneralManagerCount(
				this.employeeRepository.activeCountByClassification(EmployeeClassification.GENERAL_MANAGER)
			);
	}
	
	private EmployeeRepositoryInterface employeeRepository;
	public EmployeeRepositoryInterface getProductRepository() {
		return this.employeeRepository;
	}
	public ActiveEmployeeCountsQuery setProductRepository(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
		return this;
	}
	
	public ActiveEmployeeCountsQuery() {
		this.employeeRepository = new EmployeeRepository();
	}
}
