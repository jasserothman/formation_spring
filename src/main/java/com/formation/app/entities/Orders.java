package com.formation.app.entities;

import java.util.Date;

import javax.persistence.*;



@Entity
public class Orders {

@Id
@GeneratedValue(strategy= GenerationType.AUTO)

	private int id;

	private Date createdDate;
	
	private double totalMount;
	
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public double getTotalMount() {
		return totalMount;
	}
	public void setTotalMount(double totalMount) {
		this.totalMount = totalMount;
	}
	

	

}
