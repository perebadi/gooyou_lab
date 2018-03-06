package com.pbc.goyou.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

public class GoyouContactModel {
	private int id;
	private int customerid;
	private String type;
	private String contactname;
	private boolean emailing;
	private String email;
	private String landphone;
	private String mobilephone;
	private String position;
	private String startdate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
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
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public GoyouContactModel(int id, int customerid, String type, String contactname, boolean emailing, String email,
			String landphone, String mobilephone, String position, String startdate) {
		super();
		this.id = id;
		this.customerid = customerid;
		this.type = type;
		this.contactname = contactname;
		this.emailing = emailing;
		this.email = email;
		this.landphone = landphone;
		this.mobilephone = mobilephone;
		this.position = position;
		this.startdate = startdate;
	}
	public GoyouContactModel() {
		
	}
	
	
	
}
