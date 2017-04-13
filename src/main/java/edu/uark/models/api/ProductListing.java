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

	public ProductListing countProducts (List<Product> products){
		return this.size();
	}

	public boolean compareListings(ProductListing list2){
		if (this.size() != list2.size()){  
			return false; //obv. not equal if they have different # of items
		}
		else { //at this point they might be the same
			for (int i = 0; i < this.size(); i++){ //for each item in the list
				if (!(this.get(i).isSameProduct(list2.get(i)))){ //if they not the same
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
