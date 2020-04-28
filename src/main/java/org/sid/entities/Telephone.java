package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Telephone implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id  @GeneratedValue
	private Long id;
	private String name;
	private String telimg;
	
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "marque_id", nullable = false)
	    @JsonIgnore
	    private Marque marque;

	public Telephone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Telephone(String name, String telimg) {
		super();
		this.name = name;
		this.telimg = telimg;
	}

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

	public String getTelimg() {
		return telimg;
	}

	public void setTelimg(String telimg) {
		this.telimg = telimg;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	 
}
