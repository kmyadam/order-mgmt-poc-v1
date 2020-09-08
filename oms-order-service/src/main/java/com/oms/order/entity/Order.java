package com.oms.order.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.time.DateFormatUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oms.constants.Constants;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="OMS_ORDER")
public class Order implements Serializable {

	private static final long serialVersionUID = -3013687184464462892L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="customer_name", nullable=false, length = 100)
    private String customerName;
    
    @JsonIgnore
    @Column(name="order_date", nullable=false)
    private Date orderDateDB;
    
    @Column(name="shipping_address", nullable=false, length = 500)
    private String shippingAddress;
    
    @ApiModelProperty(notes="orderDate - MM/dd/yyyy", name="orderDate", required=false, value="")
    @Transient
    private String orderDate;
    @Transient
    private List<OrderItem> orderItems;
    
    @Transient
    private String totalPrice;
    
    /**
     * 
     */
	public Order() {
		super();
	}

	/**
	 * Order
	 * @param id
	 * @param customerName
	 * @param orderDateDB
	 * @param shippingAddress
	 */
	public Order(Long id, String customerName, Date orderDateDB, String shippingAddress) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.orderDateDB = orderDateDB;
		this.shippingAddress = shippingAddress;
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
	 * @return the orderDateDB
	 */
	public Date getOrderDateDB() {
		return orderDateDB;
	}

	/**
	 * @param orderDateDB the orderDateDB to set
	 */
	public void setOrderDateDB(Date orderDateDB) {
		this.orderDateDB = orderDateDB;
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
	 * @return the orderItems
	 */
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	/**
	 * @param orderItems the orderItems to set
	 */
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	/**
	 * @return the orderDate
	 */
	public String getOrderDate() {
		return DateFormatUtils.format(orderDateDB, Constants.DATE_FORMAT);
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the totalPrice
	 */
	public String getTotalPrice() {
		Double total = 0D;
		if(null != orderItems) {
			for(OrderItem orderItem : orderItems) {
				total = total + orderItem.getTotalPrice();
			}
		}
		return Constants.df.format(total);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerName=" + customerName + ", shippingAddress=" + shippingAddress
				+ ", orderDate=" + orderDate + ", orderItems=" + orderItems + "]";
	}

}