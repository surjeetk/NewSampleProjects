package com.test.pojo;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

@Entity
@javax.persistence.SequenceGenerator(name = "SEQ_GEN", sequenceName = "student_seq")
@javax.persistence.TableGenerator(name = "TAB_GEN", table = "GENERATOR_TABLE", pkColumnName = "key", valueColumnName = "hi", pkColumnValue = "EMP", allocationSize = 20)
@Table(name = "STUDENT")
public class Student {
	// not working below generators
	@GeneratedValue(generator = "TAB_GEN")
	@GenericGenerator(name = "TAB_GEN", strategy = "native")
	private int studentID;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(column = @Column(name = "bornCountryName"), name = "name"),
			@AttributeOverride(column = @Column(name = "bornIso2"), name = "iso2") })
	Country bornIn;

	public enum Gender {
		MALE, FEMALE;
	}

	public Student() {
	}

	public Country getBornIn() {
		return bornIn;
	}

	public void setBornIn(Country bornIn) {
		this.bornIn = bornIn;
	}

	public Student(String rollno) {
		this.rollno = rollno;
	}

	@Id
	private String rollno;

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Column(length = 100)
	private String name;

	private int version;

	@Temporal(TemporalType.TIMESTAMP)
	private Date time;

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Enumerated(EnumType.ORDINAL)
	private Gender gender;

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	
	//Many to one demo
	@ManyToOne(cascade=CascadeType.ALL)
	private Department dprt;
	
	
	
	
	public Department getDprt() {
		return dprt;
	}

	public void setDprt(Department dprt) {
		this.dprt = dprt;
	}

	//@PrimaryKeyJoinColumn(referencedColumnName="ADDR_ID")
	//@JoinColumn(name = "ADDR_ID")
	@OneToOne(cascade = CascadeType.ALL)
	private Address addr;

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

}
