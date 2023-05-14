package com.formation.app.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import com.formation.app.enums.ProviderStatus;

@Entity
@Table(name = "providers")
public class Provider implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank(message="provider name can't be Empty")
	private String name;
	@NotBlank(message="provider lastName can't be Empty")
	private String surname;
	@NotBlank(message = "mobileNumber is required")
	@Size(message="le num doit etre 8 chiffre",min = 8, max = 8)
	
	private String phone;
	@NotBlank(message="provider adresse can't be Empty")
	private String adress;
	private boolean active;

	@OneToMany(mappedBy = "provider", fetch = FetchType.EAGER)
	private List<Product> products;

	@Enumerated(EnumType.STRING)
	private ProviderStatus providerStatus;

	
	
	
	public Provider() {
	
	}
	

	public Provider(long id, String name, String surname, String phone, String adress, boolean active,
			List<Product> products, ProviderStatus providerStatus) {
		super();
		this.id = id;
		
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.adress = adress;
		this.active = active;
		this.products = products;
		this.providerStatus = providerStatus;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public ProviderStatus getProviderStatus() {
		return providerStatus;
	}

	public void setProviderStatus(ProviderStatus providerStatus) {
		this.providerStatus = providerStatus;
	}

	@Override
	public String toString() {
		return "Provider [id=" + id + ", name=" + name + ", surname=" + surname + ", phone=" + phone + ", adress="
				+ adress + ", active=" + active + ", products=" + products + ", providerStatus=" + providerStatus + "]";
	}

}
