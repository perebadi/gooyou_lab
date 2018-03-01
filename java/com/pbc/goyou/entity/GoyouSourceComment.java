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

import org.springframework.format.annotation.DateTimeFormat;

import com.mysql.jdbc.Blob;

@Entity
@Table(name = "goyou_source_comment")
public class GoyouSourceComment {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "startdate")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startdate;

	@Column(name = "comment")
	@Lob
	private Blob jobdescription;

	@ManyToOne(fetch = FetchType.EAGER)
	private GoyouSource source;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Blob getJobdescription() {
		return jobdescription;
	}

	public void setJobdescription(Blob jobdescription) {
		this.jobdescription = jobdescription;
	}

	public GoyouSource getSource() {
		return source;
	}

	public void setSource(GoyouSource source) {
		this.source = source;
	}

	public GoyouSourceComment() {

	}

	public GoyouSourceComment(int id, Date startdate, Blob jobdescription, GoyouSource source) {
		super();
		this.id = id;
		this.startdate = startdate;
		this.jobdescription = jobdescription;
		this.source = source;
	}

}
