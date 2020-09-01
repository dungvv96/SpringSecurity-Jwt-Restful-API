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
@Table(name = "FUNCTIONS")
public class Functions implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_FUNCTIONS_GEN")
    @SequenceGenerator(sequenceName = "SQ_FUNCTIONS", allocationSize = 1, name = "SQ_FUNCTIONS_GEN")
	private Long id;
	
	@Column
	@Field(index=Index.YES,analyze=Analyze.YES,store=Store.NO)
	private String functionCode;
	
	@Column
	@Field(index=Index.YES,analyze=Analyze.YES,store=Store.NO)
	private String functionName;
	
	@Column
	@Field(index=Index.YES,analyze=Analyze.YES,store=Store.NO)
	private String linkApi;
	
	@Column
	@Field(index=Index.YES,analyze=Analyze.YES,store=Store.NO)
	private String descriptions;
	
	@Column
	@Field(index=Index.YES,analyze=Analyze.YES,store=Store.NO)
	private String status;
	
	@Column
	@Field(index=Index.YES,analyze=Analyze.YES,store=Store.NO)
	private int numbers;
	
	@OneToMany(mappedBy = "function")
	private Set<RolesFunctions> listRolesFunctions = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getLinkApi() {
		return linkApi;
	}

	public void setLinkApi(String linkApi) {
		this.linkApi = linkApi;
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

}
