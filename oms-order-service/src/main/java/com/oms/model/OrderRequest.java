package com.oms.model;

import java.io.Serializable;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class OrderRequest implements Serializable {

	private static final long serialVersionUID = 1081208067382070780L;
    
	@ApiModelProperty(notes="customerName should have at least 2 characters and max of 100 characters", name="customerName", required=true, value="")
	@NotEmpty
	@Size(min=2, max=100, message="customerName should have at least 2 characters and max of 100 characters")
    private String customerName;
    
	@ApiModelProperty(notes="shippingAddress should have at least 10 characters and max of 500 characters", name="shippingAddress", required=true, value="")
	@NotEmpty
	@Size(min=10, max=500, message="shippingAddress should have at least 10 characters and max of 500 characters")
    private String shippingAddress;
    
	@ApiModelProperty(notes="items - at least one item is required", name="items", required=true, value="")
	@NotNull(message="items are required")
	@Valid
	private Set<Item> items;

	/**
	 * OrderRequest
	 */
	public OrderRequest() {
		super();
	}

	/**
	 * OrderRequest
	 * @param customerName
	 * @param shippingAddress
	 * @param items
	 */
	public OrderRequest(String customerName, String shippingAddress, Set<Item> items) {
		super();
		this.customerName = customerName;
		this.shippingAddress = shippingAddress;
		this.items = items;
	}

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