/**
 * 
 */
package com.flipped.repository;

import java.util.List;

import com.flipped.entity.Roles;

/**
 * @author zz6unp
 *
 */
public interface RolesRepository {
	void create(Roles role);
	void update(Roles role);
	void delete(Long id);
	Roles findById(Long id);
	List<Roles> findAll();
	Roles findByRoleCode(String roleCode);
	List<Roles> find(String keyword);
}
