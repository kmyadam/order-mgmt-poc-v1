package com.oms.model;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class OrderRequest implements Serializable {

	private static final long serialVersionUID = 1081208067382070780L;
    
	@NotEmpty
	@Size(min=2, max=100, message="customerName should have atleast 2 characters and max of 100 characters")
    private String customerName;
    
	@NotEmpty
	@Size(min=10, max=500, message="shippingAddress should have atleast 10 characters and max of 500 characters")
    private String shippingAddress;
    
    @NotEmpty
	private Set<Item> items;

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the shippingAddress
	 */
	public String getShippingAddress() {
		return shippingAddress;
	}

	/**
	 * @param shippingAddress the shippingAddress to set
	 */
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	/**
	 * @return the items
	 */
	public Set<Item> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "OrderRequest [customerName=" + customerName + ", shippingAddress=" + shippingAddress + ", items="
				+ items + "]";
	}

}