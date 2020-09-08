package com.oms.item.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="OMS_PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 1081208067382070780L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@ApiModelProperty(notes="name should have at least 10 characters and max of 100 characters", name="name", required=true, value="")
	@NotEmpty
	@Size(min=10, max=100, message="name should have at least 10 characters and max of 100 characters")
	@Column(name="name", nullable=false, length = 100)
    private String name;
    
	@ApiModelProperty(notes="code should have at least 2 characters and max of 100 characters", name="code", required=true, value="")
	@NotEmpty
	@Size(min=2, max=100, message="code should have at least 2 characters and max of 100 characters")
	@Column(name="code", nullable=false, length = 100)
    private String code;

	@ApiModelProperty(notes="price should have a positive number", name="price", required=true, value="")
	@NotNull
	@Min(value = 1, message="price is required")
	@Column(name = "price", nullable = false)
    @Digits(integer = 10, fraction = 2)
    private Double price;
	
    
    /**
     * 
     */
    public Product() {
		super();
	}

	/**
     * Product
     * @param id
     * @param name
     * @param code
     * @param price
     */
	public Product(Long id, String name, String code, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.price = price;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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

}