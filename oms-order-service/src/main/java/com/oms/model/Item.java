package com.oms.model;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class Item implements Serializable {

	private static final long serialVersionUID = 1081208067382070780L;
	
	@ApiModelProperty(notes="Product ID", name="productId", required=true, value="")
	@NotNull(message="product_id is required")
	@Min(value = 1, message="productId is not valid")
	private Long productId;
    
	@ApiModelProperty(notes="Product Quantity", name="quantity", required=true, value="")
	@NotNull
	@Min(value = 1, message="quantity minimum 1 is required")
	@Max(value = 10, message="quantity max 10 allowed")
    private int quantity;

	/**
	 * Item
	 */
	public Item() {
		super();
	}

	/**
	 * Item
	 * @param productId
	 * @param quantity
	 */
	public Item(Long productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}

	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [productId=" + productId + ", quantity=" + quantity + "]";
	}

}