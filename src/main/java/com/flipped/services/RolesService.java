/**
 * 
 */
package com.flipped.services;

import java.util.List;

import com.flipped.model.RolesDTO;

/**
 * @author zz6unp
 *
 */
public interface RolesService {
	void create(RolesDTO rolesDTO);
	void update(RolesDTO rolesDTO);
	void delete(Long id);
	RolesDTO findById(Long id);
	RolesDTO findByRoleCode(String roleCode);
	List<RolesDTO> find(String keyword);
	List<RolesDTO> findAll();
}
