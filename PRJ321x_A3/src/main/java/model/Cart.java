package model;

import java.util.ArrayList;

public class Cart {
	private ArrayList<Product> items;
	public Cart() {
		items= new ArrayList<>();
	}
	public void add (Product product) {
		for(Product item: items) {
			if(item.getId()==product.getId()) {
				item.setNumber(item.getNumber()+1);
				return;
			}
		}
		items.add(product);
	}
	public void remove (int id) {
		for(Product item: items) {
			if(item.getId()==id) {
				items.remove(item);
				return;
			}
		}
	}
	public double getAmount() {
		double s=0;
		for (Product item:items) {
			s+=item.getPrice()*item.getNumber();
		}
		return Math.round(s*100)/100;
	}
	public ArrayList<Product> getItems(){
		return items;
	}
}
