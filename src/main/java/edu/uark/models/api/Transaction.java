package edu.uark.models.api;

import java.time.LocalDateTime;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.models.api.enums.TransactionApiRequestStatus;
import edu.uark.models.entities.TransactionEntity;

public class Transaction {
	
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public Transaction setRecordId(UUID id) {
		this.id = id;
		return this;
	}

	private UUID cashierId;
	public UUID getCashierId() {
		return this.cashierId;
	}
	public Transaction setCashierId (UUID cashierId) {
		this.cashierId=cashierId;
		return this;
	}

	private float total;
	public float getTotal(){
		return this.total;
	}
	public Transaction setTotal (float total) {
		this.total = total;
		return this;
	}

	private String transType;
	public String getTransType(){
		return this.transType;
	}
	public Transaction transType(String transType){
		this.transType = transType;
		return this;
	}

	private UUID referenceId;
	public UUID getReferenceId(){
		return this.referenceId;
	}
	public Transaction setReferenceId(UUID referenceId){
		this.referenceId=referenceId;
		return this;
	}

	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	public Transaction setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
		return this;
	}

	private TransactionApiRequestStatus apiRequestStatus;
	public TransactionApiRequestStatus getApiRequestStatus() {
		return this.apiRequestStatus;
	}
	public Transaction setApiRequestStatus(TransactionApiRequestStatus apiRequestStatus) {
		if (this.apiRequestStatus != apiRequestStatus) {
			this apiRequestStatus=apiRequestStatus;
		}
		return this;

	private String apiRequestMessage;
	public String getApiRequestMessage() {
		return this.apiRequestMessage;
	}
	public String setApiRequestMessage(String apiRequestMessage) {
		if (!StringUtils.equalsIgnoreCase(this.apiRequestMessage, apiRequestMessage)) {
			this.apiRequestMessage = apiRequestMessage;
		}
		return this;
	}


	public Transaction() {
		this.id = new UUID(0,0);
		this.cashierId = new UUID(0,0);
		this.total = 0.00;
		this.transType="sale";
		this.referenceId = new UUID(0,0);
		this.createdOn = LocalDateTime.now();
		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = TransactionApiRequestStatus.OK;
	}

	public Transaction(TransactionEntity transactionEntity){
		this.id=transactionEntity.getRecordId();
		this.cashierId=transactionEntity.getCashierId() ;
		this.total=transactionEntity.getTotal();
		this.transType=transactionEntity.getTransType();
		this.referenceId=transactionEntity.getReferenceId() ;
		this.createdOn =transactionEntity.getCreatedOn();
		this.apiRequestMessage=StringUtils.EMPTY;
		this.apiRequestStatus=ProductApiRequestStatus.OK;
	}



}
	
