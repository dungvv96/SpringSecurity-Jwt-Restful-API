/**
 * 
 */
package com.flipped.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.search.annotations.Indexed;

/**
 * @author zz6unp
 *
 */
@Entity
@Indexed
@Table(name="ROLES_FUNCTIONS")
public class RolesFunctions implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ROLES_FUNCTIONS_GEN")
    @SequenceGenerator(sequenceName = "SQ_ROLES_FUNCTIONS", allocationSize = 1, name = "SQ_ROLES_FUNCTIONS_GEN")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ROLE_ID", nullable = false)
	private Roles role;
	
	@ManyToOne
	@JoinColumn(name="FUNCTION_ID", nullable = false)
	private Functions function;
	
	@Column
	private String descriptions;
	
	@Column
	private boolean authView;
	
	@Column
	private boolean authCreate;
	
	@Column
	private boolean authUpdate;
	
	@Column
	private boolean authDelete;
	
	@Column
	private String status;
	
	@Column 
	private int numbers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public Functions getFunction() {
		return function;
	}

	public void setFunction(Functions function) {
		this.function = function;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

	public boolean isAuthView() {
		return authView;
	}

	public void setAuthView(boolean authView) {
		this.authView = authView;
	}

	public boolean isAuthCreate() {
		return authCreate;
	}

	public void setAuthCreate(boolean authCreate) {
		this.authCreate = authCreate;
	}

	public boolean isAuthUpdate() {
		return authUpdate;
	}

	public void setAuthUpdate(boolean authUpdate) {
		this.authUpdate = authUpdate;
	}

	public boolean isAuthDelete() {
		return authDelete;
	}

	public void setAuthDelete(boolean authDelete) {
		this.authDelete = authDelete;
	}


	
	
}
