package com.oms.order.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

@Entity
@Table(name="OMS_ORDER_ITEM")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = -7591153885699798770L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "order_id", nullable = false)
    private Long orderId;
	
	@Column(name = "product_id", nullable = false)
    private Long productId;
    
    @Column(name = "product_name", nullable = false)
    private String productName;
    
    @Column(name = "product_code", nullable = false)
    private String productCode;
    
    @Column(name = "quantity", nullable = false)
    @Min(1)
    private Integer quantity;

    @Column(name = "price", nullable = false)
    @Digits(integer = 10, fraction = 2)
    private Double price;
    
    @Transient
    private Double totalPrice;

    /**
     * 
     */
    public OrderItem() {
		super();
	}
    
    /**
     * OrderItem
     * @param id
     * @param orderId
     * @param productId
     * @param productName
     * @param productCode
     * @param quantity
     * @param price
     * @param totalPrice
     */
	public OrderItem(Long orderId, Long productId, String productName, String productCode, 
			Integer quantity, Double price, Double totalPrice) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.productName = productName;
		this.productCode = productCode;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantiy the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the totalPrice
	 */
	public Double getTotalPrice() {
		return quantity * price;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", orderId=" + orderId + ", productId=" + productId + ", productName="
				+ productName + ", productCode=" + productCode + ", quantity=" + quantity + ", price=" + price
				+ ", totalPrice=" + totalPrice + "]";
	}

}
