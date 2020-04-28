package org.sid.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Marque implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id  @GeneratedValue
	private Long id;
	
	private String name;
	private String mrqimg;
	
	 @OneToMany(mappedBy = "marque", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private Set<Telephone> telephones;
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMrqimg() {
		return mrqimg;
	}
	public void setMrqimg(String mrqimg) {
		this.mrqimg = mrqimg;
	}
	
	public Set<Telephone> getTelephones() {
		return telephones;
	}
	public void setTelephones(Set<Telephone> telephones) {
		this.telephones = telephones;
	}
	public Marque() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Marque(String name, String mrqimg) {
		super();
		this.name = name;
		this.mrqimg = mrqimg;
	}
	
	
	
	
	
}
