package com.pbc.goyou.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.mysql.jdbc.Blob;

@Entity
@Table(name = "goyou_source")
public class GoyouSource {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "summary")
	private String summary;

	@Column(name = "jobdescription")
	@Lob
	private Blob jobdescription;

	@Column(name = "datesource")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date datesource;

	@Column(name = "status")
	private String status;

	@ManyToOne(fetch = FetchType.EAGER)
	private GoyouCustomer customer;

	@OneToOne(fetch = FetchType.LAZY)
	private GoyouContact contact;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "source")
	private Set<GoyouSourceComment> comments = new HashSet<GoyouSourceComment>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "source")
	private Set<GoyouToDo> todos = new HashSet<GoyouToDo>();

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

	public Blob getJobdescription() {
		return jobdescription;
	}

	public void setJobdescription(Blob jobdescription) {
		this.jobdescription = jobdescription;
	}

	public Date getDatesource() {
		return datesource;
	}

	public void setDatesource(Date datesource) {
		this.datesource = datesource;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public GoyouCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(GoyouCustomer customer) {
		this.customer = customer;
	}

	public GoyouContact getContact() {
		return contact;
	}

	public void setContact(GoyouContact contact) {
		this.contact = contact;
	}

	public Set<GoyouSourceComment> getComments() {
		return comments;
	}

	public void setComments(Set<GoyouSourceComment> comments) {
		this.comments = comments;
	}

	public GoyouSource() {

	}

	public GoyouSource(int id, String summary, Blob jobdescription, Date datesource, String status,
			GoyouCustomer customer, GoyouContact contact, Set<GoyouSourceComment> comments) {
		super();
		this.id = id;
		this.summary = summary;
		this.jobdescription = jobdescription;
		this.datesource = datesource;
		this.status = status;
		this.customer = customer;
		this.contact = contact;
		this.comments = comments;
	}

}
