package com.pbc.goyou.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "goyou_contact")
public class GoyouContact {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "type")
	private String type;

	@Column(name = "contactname")
	private String contactname;

	@Column(name = "emailing")
	private boolean emailing = true;

	@Column(name = "email")
	private String email;
	
	@Column(name = "landphone")
	private String landphone;
	
	@Column(name = "mobilephone")
	private String mobilephone;
	
	@Column(name = "position")
	private String position;

	@Column(name = "startdate")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startdate;

	@ManyToOne(fetch=FetchType.EAGER)
	private GoyouCustomer customer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContactname() {
		return contactname;
	}

	public void setContactname(String contactname) {
		this.contactname = contactname;
	}

	public boolean isEmailing() {
		return emailing;
	}

	public void setEmailing(boolean emailing) {
		this.emailing = emailing;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLandphone() {
		return landphone;
	}

	public void setLandphone(String landphone) {
		this.landphone = landphone;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public GoyouCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(GoyouCustomer customer) {
		this.customer = customer;
	}

	public GoyouContact(int id, String type, String contactname, boolean emailing, String email, String landphone,
			String mobilephone, String position, Date startdate, GoyouCustomer customer) {
		super();
		this.id = id;
		this.type = type;
		this.contactname = contactname;
		this.emailing = emailing;
		this.email = email;
		this.landphone = landphone;
		this.mobilephone = mobilephone;
		this.position = position;
		this.startdate = startdate;
		this.customer = customer;
	}
	
	public GoyouContact() {
		
	}
	
	

}
