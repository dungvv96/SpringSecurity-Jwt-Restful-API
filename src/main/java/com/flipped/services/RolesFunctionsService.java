/**
 * 
 */
package com.flipped.services;

import java.util.List;

import com.flipped.model.RolesFunctionsDTO;

/**
 * @author zz6unp
 *
 */
public interface RolesFunctionsService {
	void create(RolesFunctionsDTO rolesFunctionsDTO);
	void update(RolesFunctionsDTO rolesFunctionsDTO);
	void delete(Long id);
	RolesFunctionsDTO findById(Long id);
	List<RolesFunctionsDTO> find();
	List<RolesFunctionsDTO> findByRoleId(Long roleId);
}
