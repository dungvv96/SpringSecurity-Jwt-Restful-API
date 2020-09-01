/**
 * 
 */
package com.flipped.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

/**
 * @author zz6unp
 *
 */
@Entity
@Indexed
@Table(name="USERS")
public class Users implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USERS_GEN")
    @SequenceGenerator(sequenceName = "SQ_USERS", allocationSize = 1, name = "SQ_USERS_GEN")
	private Long id;
	
	@Column
	@Field(index=Index.YES,analyze=Analyze.YES,store=Store.NO)
	private String username;
	
	@Column
	private String password;
	
	@Column
	@Field(index=Index.YES,analyze=Analyze.YES,store=Store.NO)
	private String fullname;
	
	@Column
	@Field(index=Index.YES,analyze=Analyze.YES,store=Store.NO)
	private String email;
	
	@Column
	@Field(index=Index.YES,analyze=Analyze.YES,store=Store.NO)
	private String phoneNumber;
	
	@Column
	@Field(index=Index.YES,analyze=Analyze.YES,store=Store.NO)
	private String descriptions;
	
	@Temporal(TemporalType.DATE)
	private Date dateCreated;
	
	@Temporal(TemporalType.DATE)
	private Date dateLogin;
	
	@Temporal(TemporalType.DATE)
	private Date dateUpdated;
	
	@ManyToOne
	@JoinColumn(name="ROLE_ID")
	private Roles role;
	
	@Column
	@Field(index=Index.YES,analyze=Analyze.YES,store=Store.NO)
	private String status;

	@Column
	private boolean enabled;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateLogin() {
		return dateLogin;
	}

	public void setDateLogin(Date dateLogin) {
		this.dateLogin = dateLogin;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
