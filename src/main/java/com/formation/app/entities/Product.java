package com.formation.app.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="products")
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Size(min = 2, message = "user name should have at least 2 characters")
	@NotBlank(message="product name can't be Empty")
	private String name;
	private int quantity;
	@NotBlank(message="Description can't be Empty")
	private String description;
	private String reference ;
	@Column(name = "availability", nullable = false)
	private boolean isAvailable;
	
	private boolean isOnSell;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date creationDate;
	
	
	@ManyToOne
	@JoinColumn(name="PROVIDER_ID")
	private Provider provider;
	
	public Product() {
		
	}
	

	public Product(long id, String name, int quantity, String description, String reference, boolean isAvailable,
			boolean isOnSell, Date creationDate, Provider provider) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.description = description;
		this.reference = reference;
		this.isAvailable = isAvailable;
		this.isOnSell = isOnSell;
		this.creationDate = creationDate;
		this.provider = provider;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean getIsAvailable() {
		return isAvailable;
	}


	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}


	public boolean getIsOnSell() {
		return isOnSell;
	}


	public void setIsOnSell(boolean isOnSell) {
		this.isOnSell = isOnSell;
	}


	public Provider getProvider() {
		return provider;
	}


	public void setProvider(Provider provider) {
		this.provider = provider;
	}


	public String getReference() {
		return reference;
	}


	public void setReference(String reference) {
		this.reference = reference;
	}





	
	

}
