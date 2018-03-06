package com.pbc.goyou.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "goyou_sites")
public class GoyouSites {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "site")
	private String site;

	@ManyToOne(fetch = FetchType.EAGER)
	private GoyouSource source;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSite() {
		return site;
	}

	public void setSites(String site) {
		this.site = site;
	}

	public GoyouSource getSource() {
		return source;
	}

	public void setSource(GoyouSource source) {
		this.source = source;
	}

	public GoyouSites(int id, String site, GoyouSource source) {
		super();
		this.id = id;
		this.site = site;
		this.source = source;
	}

	public GoyouSites() {

	}

}
