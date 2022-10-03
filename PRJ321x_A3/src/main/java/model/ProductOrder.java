package model;

public class ProductOrder {
	private int orderId;
	private int productId;
	private int productQuantity;
	private Double amountProduct;
	private String nameProduct;
	public ProductOrder (int orderId, int productId,int productQuantity, Double amountProduct, String nameProduct) {
		this.orderId=orderId;
		this.productId=productId;
		this.productQuantity=productQuantity;
		this.amountProduct=amountProduct;
		this.nameProduct=nameProduct;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public Double getAmountProduct() {
		return amountProduct;
	}
	public void setAmountProduct(double amountProduct) {
		this.amountProduct = amountProduct;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	

}
