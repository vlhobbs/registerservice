package edu.uark.models.repositories.interfaces;

import edu.uark.dataaccess.repository.BaseRepositoryInterface;
import edu.uark.models.entities.TransactionEntity;
import edu.uark.models.enums.TransactionClassification;

public interface TransactionRepositoryInterface extends BaseRepositoryInterface<EmployeeEntity> {
	boolean transactionIdExists(String transactionId);
	TransactionEntity byTransactionId(String transactionId);
	//int activeCountByClassification(EmployeeClassification employeeClassification);
}
