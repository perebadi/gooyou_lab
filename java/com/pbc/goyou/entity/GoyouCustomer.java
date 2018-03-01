package com.pbc.goyou.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "goyou_customer")
public class GoyouCustomer {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "oldid")
	private int oldid;

	@Column(name = "customername")
	private String customername;

	@Column(name = "email")
	private String email;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "emailing")
	private boolean emailing = true;

	@Column(name = "company_phone")
	private String phone;
	
	@Column(name = "address", length=200)
	private String address;
	
	@Column(name = "postalcode", length=5)
	private String postalcode;
	
	@Column(name = "city", length=200)
	private String city;
	
	@Column(name = "province", length=200)
	private String province;

	@Column(name = "startdate")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startdate;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
	private Set<GoyouSource> sources = new HashSet<GoyouSource>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
	private Set<GoyouContact> contacts = new HashSet<GoyouContact>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
	private Set<GoyouCustomerComment> comments = new HashSet<GoyouCustomerComment>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
	private Set<GoyouToDo> todos = new HashSet<GoyouToDo>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEmailing() {
		return emailing;
	}

	public void setEmailing(boolean emailing) {
		this.emailing = emailing;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Set<GoyouSource> getSources() {
		return sources;
	}

	public void setSources(Set<GoyouSource> sources) {
		this.sources = sources;
	}

	public Set<GoyouContact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<GoyouContact> contacts) {
		this.contacts = contacts;
	}

	public Set<GoyouCustomerComment> getComments() {
		return comments;
	}

	public void setComments(Set<GoyouCustomerComment> comments) {
		this.comments = comments;
	}
	
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Set<GoyouToDo> getTodos() {
		return todos;
	}

	public void setTodos(Set<GoyouToDo> todos) {
		this.todos = todos;
	}

	public GoyouCustomer() {

	}

	public GoyouCustomer(int id, String customername, String email, String image, boolean emailing, String phone,
			String address, String postalcode, String city, String province, Date startdate, Set<GoyouSource> sources,
			Set<GoyouContact> contacts, Set<GoyouCustomerComment> comments, Set<GoyouToDo> todos) {
		super();
		this.id = id;
		this.customername = customername;
		this.email = email;
		this.image = image;
		this.emailing = emailing;
		this.phone = phone;
		this.address = address;
		this.postalcode = postalcode;
		this.city = city;
		this.province = province;
		this.startdate = startdate;
		this.sources = sources;
		this.contacts = contacts;
		this.comments = comments;
		this.todos = todos;
	}

	



}
