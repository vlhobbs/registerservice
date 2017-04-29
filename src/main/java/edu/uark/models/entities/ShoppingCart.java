package edu.uark.models.entities;
import java.util.ArrayList;
import edu.uark.models.entities.ProductEntity;
public class ShoppingCart
{
	ArrayList<ProductEntity> cart;
	int count;
	int totalPrice; 
	
	public ShoppingCart()
	{
	  cart = new ArrayList();
	  count = 0;
	  totalPrice = 0;
	}

	//public ShoppingCart(TransactionEntity transaction){
			
	 
	public void add(ProductEntity input, int quantity)
	{
		cart.add(input);
		count += quantity;
		totalPrice += (quantity * input.getPrice());
	}
	
	public void remove(ProductEntity input, int quantity)
	{
		cart.remove(input);
		count -= quantity; 
		totalPrice -= (quantity * input.getPrice()); 
	}
	
	public int getTotalPrice()
	{
		return totalPrice;
	}
	
	public int getCount()
	{
		return count; 
	}
	
	public ArrayList<ProductEntity> getList()
	{
		return cart;
	}
}