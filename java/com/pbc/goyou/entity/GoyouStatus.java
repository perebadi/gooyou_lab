package com.pbc.goyou.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "goyou_staus")
public class GoyouStatus {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "status", length=200)
	private String status;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "goyouStatus")
	private Set<GoyouToDo> todos = new HashSet<GoyouToDo>();
	
}