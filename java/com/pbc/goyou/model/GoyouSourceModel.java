package com.pbc.goyou.model;

import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.soap.SAAJMetaFactory;

import com.mysql.jdbc.Blob;
import com.pbc.goyou.entity.GoyouContact;
import com.pbc.goyou.entity.GoyouCustomer;
import com.pbc.goyou.entity.GoyouSites;
import com.pbc.goyou.entity.GoyouSourceComment;
import com.pbc.goyou.entity.GoyouToDo;

public class GoyouSourceModel {

	private int id;

	@NotNull
	@Size(min = 10)
	private String summary;

	@NotNull
	private String jobdescription;

	@NotNull
	@Size(min = 10)
	private String datesource;

	@NotNull
	@Size(min = 3)
	private String status;

	@NotNull
	private int customer;

	@NotNull
	private int contact;

	private String sites;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getJobdescription() {
		return jobdescription;
	}

	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}

	public String getDatesource() {
		return datesource;
	}

	public void setDatesource(String datesource) {
		this.datesource = datesource;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCustomer() {
		return customer;
	}

	public void setCustomer(int customer) {
		this.customer = customer;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}


	public String getSites() {
		return sites;
	}

	public void setSites(String sites) {
		this.sites = sites;
	}

	public GoyouSourceModel() {

	}

	public GoyouSourceModel(int id, String summary, String jobdescription, String datesource, String status, int customer,
			int contact, String sites) {
		super();
		this.id = id;
		this.summary = summary;
		this.jobdescription = jobdescription;
		this.datesource = datesource;
		this.status = status;
		this.customer = customer;
		this.contact = contact;
		this.sites = sites;
	}

}
