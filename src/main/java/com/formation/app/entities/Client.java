package com.formation.app.entities;

import java.io.Serializable;

import javax.persistence.*;



@Entity
public class Client implements Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String surname;
	private long phone;
	private String adress;
	private boolean solvent;
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
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public boolean isSolvent() {
		return solvent;
	}
	public void setSolvent(boolean solvent) {
		this.solvent = solvent;
	}
	
	

}
