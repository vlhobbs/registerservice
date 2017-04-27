package edu.uark.models.repositories;

import java.sql.SQLException;

import edu.uark.dataaccess.repository.BaseRepository;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.dataaccess.repository.helpers.SQLComparisonType;
import edu.uark.dataaccess.repository.helpers.SQLConditionalType;
import edu.uark.dataaccess.repository.helpers.where.WhereClause;
import edu.uark.dataaccess.repository.helpers.where.WhereContainer;
import edu.uark.models.entities.TransactionEntity;
import edu.uark.models.entities.fieldnames.TransactionFieldNames;
import edu.uark.models.enums.TransactionTypeClassification;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;

public class TransactionRepository extends BaseRepository<TransactionEntity> implements TransactionRepositoryInterface {
	@Override
	public boolean transactionIdExists(String transactionId) {
		return this.existsWhere(
			new WhereContainer(
				(new WhereClause()).
					table(this.primaryTable).
					fieldName(TransactionFieldNames.CASHIERID).
					comparison(SQLComparisonType.EQUALS)
			),
			(ps) -> {
				try {
					ps.setObject(1, transactionId);
				} catch (SQLException e) {}

				return ps;
			}
		);
	}



	@Override
	public TransactionEntity byTransactionId(String transactionId) {
		return this.firstOrDefaultWhere(
			new WhereContainer(
				(new WhereClause()).
					table(this.primaryTable).
					fieldName(TransactionFieldNames.REFID).
					comparison(SQLComparisonType.EQUALS)
			),
			(ps) -> {
				try {
					ps.setObject(1, transactionId);
				} catch (SQLException e) {}

				return ps;
			}
		);
	}
/*

Will make two of these - one to return sales, one to return returns.
After that, we'll see what we need.
Also need to edit TransactionRepositoryInterface and add them there.
	
	@Override
	public int activeCountByClassification(EmployeeClassification employeeClassification) {
		return this.countWhere(
			new WhereContainer(
				(new WhereClause()).
					table(this.primaryTable).
					fieldName(EmployeeFieldNames.CLASSIFICATION).
					comparison(SQLComparisonType.EQUALS)
			).addWhereClause(
				(new WhereClause()).
					conditional(SQLConditionalType.AND).
					table(this.primaryTable).
					fieldName(EmployeeFieldNames.ACTIVE).
					comparison(SQLComparisonType.EQUALS)
			),
			(ps) -> {
				try {
					ps.setObject(1, employeeClassification.getValue());
					ps.setObject(2, true);
				} catch (SQLException e) {}

				return ps;
			}
		);
	}
*/
	@Override
	public TransactionEntity createOne() {
		return new TransactionEntity();
	}
	
	public TransactionRepository() {
		super(DatabaseTable.TRANSACTION);
	}
}