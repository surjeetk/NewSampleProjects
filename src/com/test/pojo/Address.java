package com.test.pojo;

/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;*/


import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="ADDRESS")
public class Address {
	
	Country nationality;

	private String city;
	
	public Country getNationality() {
		return nationality;
	}

	public void setNationality(Country nationality) {
		this.nationality = nationality;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int addr_id;
	
	private String pincode;
	
	//@Version
	private int version;
	
	@Basic(fetch=FetchType.LAZY)
	private String road;
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public int getAddr_id() {
		return addr_id;
	}

	public void setAddr_id(int addr_id) {
		this.addr_id = addr_id;
	}

	
	
}


