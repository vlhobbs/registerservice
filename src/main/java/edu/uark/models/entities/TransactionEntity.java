package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.models.api.Transaction;
import edu.uark.models.entities.fieldnames.TransactionFieldNames;
import edu.uark.models.repositories.TransactionRepository;
import edu.uark.models.api.enums.ProductApiRequestStatus;
import edu.uark.models.entities.ProductEntity;
import edu.uark.models.api.Product.java
import edu.uark.models.api.ProductListing.java

public class TransactionEntity extends BaseEntity<TransactionEntity> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.id = rs.getString(TransactionFieldNames.ID); 
		this.cashierId = rs.getString(TransactionFieldNames.CASHIERID);
                this.total = rs.getFloat(TransactionFieldNames.TOTAL);
                this.transType = rs.getString(TransactionFieldNames.TRANSTYPE);
                this.referenceId = rs.getString(REFID); 
		this.createdOn = rs.getTimestamp(TransactionFieldNames.CREATED_ON).toLocalDateTime();
		//figure out how to get products later...
		//this.products = new ProductListing();
                
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(TransactionFieldNames.ID, this.id);
		record.put(TransactionFieldNames.CASHIERID, this.cashierId);
                record.put(TransactionFieldNames.TOTAL, this.total);
                record.put(TransactionFieldNames.TRANSTYPE, this.transType);
                record.put(TransactionFieldNames.REFID, this.referenceId);
                record.put(TransactionFieldNames.CREATED_ON, Timestamp.valueOf(this.createdOn));
		//Again figure out product list
		return record;
	}

	private String id;
	public String getId() {
		return this.id;
	}
	public TransactionEntity setRecordId(String id) {
		if (!StringUtils.equals(this.id, id)) {
			this.id = id;
			this.propertyChanged(TransactionFieldNames.LOOKUP_CODE);
		}
		
		return this;
	}

        private String cashierId;
        public String getCashierId(){
		return this.cashierId;
	}

	public TransactionEntity setCashierId(String cashierId) {
		if (!StringUtils.equals(this.cashierId, cashierId)) {
			this.cashierId = cashierId;
			this.propertyChanged(TransactionFieldNames.CASHIERID);
		}
	} 
	
	private float total;
	public float getTotal(){
		return this.total;	
	} 
	
	public TransactionEntity setTotal(float total){
		if (this.total != total) {
			this.total = total;
			this.propertyChanged(TransactionFieldNames.TOTAL);
		}
		return this;
	}	

	private String transType;
	public String getTransType(){
		return this.transType;
	}

	public TransactionEntity setTransType(String transType){
		if (!StringUtils.equals(this.transType, transType)) {
			this.transType = transType;
			this.propertyChanged(TransactionFieldNames.TRANSTYPE);
		}
		return this;
	}

	private String referenceId;
	public String getReferenceId() {		
		return this.referenceId;
	}

	public TransactionEntity setReferenceId(String referenceId) {
		if (!StringUtils.equals(this.referenceId, referenceId)) {
			this.referenceId = referenceId;
			this.propertyChanged(TransactionFieldNames.REFID);
		}
		return this;
	}


	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	
	private ProductListing products;
	public ProductListing getProducts(){
		return this.products;
		
	}
	
	public TransactionEntity setProducts(ProductListing products){
	//good idea to check equality once I have code to support
	//if (!(this.products.compareListings(products){
		this.products = products;
		return this;
		//}	
	}
	//This is getting into the api stuff, am going to need to update it.


	}
	
	public Transaction synchronize(Transaction apiTransaction) {
		this.setId(apiTransaction.getId());
		this.setCashierId(apiTransaction.getCashierId());
		this.setFloat(apiTransaction.getFloat());
		this.setTotal(apiTransaction.getTotal());
		this.setTransType(apiTransaction.getTransType());
		this.setReferenceId(apiTransaction.getReferenceId());
		this.setCreatedOn(apiTransaction.getCreatedOn());		
		//this.setProducts(apiTransaction.getProducts) //also needs adding
		apiTransaction.setCreatedOn(this.createdOn);
		
		return apiTransaction;
	}


	public TransactionEntity() {
		super(new TransactionRepository());
		
		this.id = StringUtils.EMPTY;
		this.cashierId = StringUtils.EMPTY;
		this.total = 0.00;
		this.transType = StringUtil.EMPTY;
		this.referenceId = StringUtils.EMPTY;
		this.createdOn=LocalDateTime.now();
		this.products=new ProductListing();
	}

	public TransactionEntity(Transaction apiTransaction){
		super(apiTransaction.getRecordId(), new TransactionRepository());

		this.id = apiTransaction.getId();
		this.cashierId = apiTransaction.getCashierId();
		this.total = apiTransaction.getTotal();
		this.transType = apiTransaction.getTransType();
		this.referenceId = apiTransaction.getReferenceId();
		this.createdOn=apiTransaction.getCreatedOn(); 
		this.products=new ProductListing();
	}	
	
	public TransactionEntity(UUID recordId){
		super(recordId, new TransactionRepository());
		
		this.id = StringUtils.EMPTY;
		this.cashierId = StringUtils.EMPTY;
		this.total = 0.00;
		this.transType = StringUtil.EMPTY;
		this.referenceId = StringUtils.EMPTY;
		this.createdOn=LocalDateTime.now();
		this.products=new ProductListing();
	}


}
