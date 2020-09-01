/**
 * 
 */
package com.flipped.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
@Table(name = "ROLES")
public class Roles implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ROLES_GEN")
    @SequenceGenerator(sequenceName = "SQ_ROLES", allocationSize = 1, name = "SQ_ROLES_GEN")
	private Long id;
	
	@Column
	@Field(index=Index.YES,analyze=Analyze.YES,store=Store.NO)
	private String roleCode;
	
	@Column
	@Field(index=Index.YES,analyze=Analyze.YES,store=Store.NO)
	private String roleName;
	
	@Column
	@Field(index=Index.YES,analyze=Analyze.YES,store=Store.NO)
	private String descriptions;
	
	@Column
	@Field(index=Index.YES,analyze=Analyze.YES,store=Store.NO)
	private String status;
	
	@Column
	private int numbers;
	
	@Column
	private int leveled;
	
	@OneToMany(mappedBy = "role")
	private Set<RolesFunctions> listRolesFunctions = new HashSet<>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	public int getLeveled() {
		return leveled;
	}

	public void setLeveled(int leveled) {
		this.leveled = leveled;
	}
}
