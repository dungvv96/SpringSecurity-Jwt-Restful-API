/**
 * 
 */
package com.flipped.model;

import java.io.Serializable;

/**
 * @author zz6unp
 *
 */
public class RolesFunctionsDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private FunctionsDTO function;
	private RolesDTO role;
	private String descriptions;
	private boolean authView;
	private boolean authCreate;
	private boolean authUpdate;
	private boolean authDelete;
	private String status;
	private int numbers;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public FunctionsDTO getFunction() {
		return function;
	}
	public void setFunction(FunctionsDTO function) {
		this.function = function;
	}
	public RolesDTO getRole() {
		return role;
	}
	public void setRole(RolesDTO role) {
		this.role = role;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
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
