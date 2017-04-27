package edu.uark.models.api;

import java.util.LinkedList;
import java.util.List;

import edu.uark.models.api.Product;

public class ProductListing {
	private List<Product> products;
	public List<Product> getProducts() {
		return this.products;
	}
	public ProductListing setProducts(List<Product> products) {
		this.products = products;
		return this;
	}
	public ProductListing addProduct(Product product) {
		this.products.add(product);
		return this;
	}

	public int getSize(){
		return this.products.size();
	}
	public boolean compareListings(ProductListing list2){
		if (this.getSize() != list2.getSize()){  
			return false; //obv. not equal if they have different # of items
		}
		else { //at this point they might be the same
			for (int i = 0; i < this.getSize(); i++){ //for each item in the list
				if (!(this.products.get(i).isSameProduct(list2.products.get(i)))){ //if they are not the same
					return false; //end the loop
				}
			}
		return true; //if they get to here, they are equal
		}
	}

	
	public ProductListing() {
		this.products = new LinkedList<Product>();
	}
}
