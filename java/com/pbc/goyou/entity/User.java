package com.pbc.goyou.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "username", unique = true, nullable = false, length = 45)
	private String username;

	@Column(name = "password", nullable = false, length = 60)
	private String password;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "rate", nullable = false)
	private float rate;
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<GoyouToDo> todos = new HashSet<GoyouToDo>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval=true)
	private Set<UserRole> userRole = new HashSet<UserRole>();




	/**
	 * Devuelve si el usuario tiene asignado un rol
	 * 
	 * @param role
	 * @return boolean
	 */
	public boolean hasRole(String role) {
		//Recorremos todos los roles del usuario
		for(UserRole userRoles : getUserRole()) {
			//Comprovamos si el usuario tiene el rol
			if(userRoles.getRole().equals(role)) {
				//Tiene el rol
				return true;
			}
		}
		
		//No tiene el rol
		return false;
	}
	
	/**
	 * Devuelve el rol que tiene el usuario asignado
	 * 
	 * @param role
	 * @return UserRole
	 */
	public UserRole getRole(String role) {
		//Recorremos todos los roles del usuario
		for(UserRole userRoles : getUserRole()) {
			//Comprovamos si el usuario tiene el rol
			if(userRoles.getRole().equals(role)) {
				//Devolvemos el rol
				return userRoles;
			}
		}
		
		//Devuelve nulo
		return null;
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}




	public User(String username, String password, boolean enabled, String name, float rate, Set<UserRole> userRole) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.name = name;
		this.rate = rate;
		this.userRole = userRole;
	}

	public User() {
	}

}
