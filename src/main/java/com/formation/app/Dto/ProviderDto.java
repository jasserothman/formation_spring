package com.formation.app.Dto;

public class ProviderDto {

	private long id=1;
	private String name="jasser";
	private String surname="othman";
	private long phone=50699061;
	private String adress="sousse";
	private boolean active=true;
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
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "ProviderDto [id=" + id + ", name=" + name + ", surname=" + surname + ", phone=" + phone + ", adress="
				+ adress + ", active=" + active + "]";
	}
	
}
