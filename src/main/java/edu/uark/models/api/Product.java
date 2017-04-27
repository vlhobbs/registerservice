package edu.uark.models.api;

import java.time.LocalDateTime;
import java.util.UUID;
//import java.math.BigDecimal; //(If rounding becomes an issue....)

import org.apache.commons.lang3.StringUtils;


import edu.uark.models.api.enums.ProductApiRequestStatus;
import edu.uark.models.entities.ProductEntity;

public class Product {
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public Product setId(UUID id) {
		this.id = id;
		return this;
	}
	
	private String lookupCode;
	public String getLookupCode() {
		return this.lookupCode;
	}
	public Product setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
		return this;
	}
	
	private int quantity;
	public int getQuantity() {
		return this.quantity;
	}
	public Product setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}
	
	private boolean salable;
	public boolean getSalable() {
		return this.salable;
	}

	public Product setSalable(boolean salable) {
		this.salable = salable;
		return this;
	}

	private double price;
	public double getPrice(){
		return this.price;
	}

	public Product setPrice(float price){
		this.price = price;
		return this;
	}	

	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	public Product setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
		return this;
	}
	
	private ProductApiRequestStatus apiRequestStatus;
	public ProductApiRequestStatus getApiRequestStatus() {
		return this.apiRequestStatus;
	}
	public Product setApiRequestStatus(ProductApiRequestStatus apiRequestStatus) {
		if (this.apiRequestStatus != apiRequestStatus) {
			this.apiRequestStatus = apiRequestStatus;
		}
		
		return this;
	}
	
	private String apiRequestMessage;
	public String getApiRequestMessage() {
		return this.apiRequestMessage;
	}
	public Product setApiRequestMessage(String apiRequestMessage) {
		if (!StringUtils.equalsIgnoreCase(this.apiRequestMessage, apiRequestMessage)) {
			this.apiRequestMessage = apiRequestMessage;
		}
		
		return this;
	}
	
	public boolean isSameProduct(Product product2){
		if 
		(this.quantity == product2.quantity &&
		StringUtils.equalsIgnoreCase(this.lookupCode, product2.lookupCode) &&
		this.id.equals(product2.id) &&
		this.salable == product2.salable &&
		this.price == product2.price &&
		this.createdOn.equals(product2.createdOn) &&
		StringUtils.equalsIgnoreCase(this.apiRequestMessage, product2.apiRequestMessage) &&
		this.apiRequestStatus == product2.apiRequestStatus) {
			return true;
		}
		else {
			return false;
		}
	}
			 
	
	public Product() {		
		this.quantity = -1;
		this.lookupCode = "";
		this.id = new UUID(0, 0);
		this.salable = false;
		this.price = 0.00;
		this.createdOn = LocalDateTime.now();
		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = ProductApiRequestStatus.OK;
	}
	
	public Product(ProductEntity productEntity) {
		this.id = productEntity.getId();
		this.quantity = productEntity.getQuantity();
		this.createdOn = productEntity.getCreatedOn();
		this.lookupCode = productEntity.getLookupCode();
		this.price = productEntity.getPrice();
		this.salable = productEntity.getSalable();
		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = ProductApiRequestStatus.OK;
	}
}
