package com.pbc.goyou.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.domain.ExampleMatcher.PropertyValueTransformer;
import org.springframework.format.annotation.DateTimeFormat;

import com.mysql.jdbc.Blob;

@Entity
@Table(name = "goyou_todo")
public class GoyouToDo {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "summary", length=200)
	private String summary;

	@Column(name = "description")
	@Lob
	private Blob description;

	@Column(name = "duedate")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startdate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private GoyouCustomer customer;

	@ManyToOne(fetch = FetchType.EAGER)
	private GoyouSource source;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private GoyouStatus goyouStatus;


	
	
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

	public Blob getDescription() {
		return description;
	}

	public void setDescription(Blob description) {
		this.description = description;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public GoyouCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(GoyouCustomer customer) {
		this.customer = customer;
	}

	public GoyouSource getSource() {
		return source;
	}

	public void setSource(GoyouSource source) {
		this.source = source;
	}

	public GoyouToDo(int id, String summary, Blob description, Date startdate, User user, GoyouCustomer customer,
			GoyouSource source) {
		super();
		this.id = id;
		this.summary = summary;
		this.description = description;
		this.startdate = startdate;
		this.user = user;
		this.customer = customer;
		this.source = source;
	}

	public GoyouToDo() {
		
	}
	
	

}
