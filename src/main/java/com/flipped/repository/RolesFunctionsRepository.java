/**
 * 
 */
package com.flipped.repository;

import java.util.List;

import com.flipped.entity.RolesFunctions;

/**
 * @author zz6unp
 *
 */
public interface RolesFunctionsRepository {
	void create(RolesFunctions rolesFunctions);
	void update(RolesFunctions rolesFunctions);
	void delete(Long id);
	RolesFunctions findById(Long id);
	RolesFunctions findByRoleCode(String roleCode);
	RolesFunctions find(String keyword);
	List<RolesFunctions> findByRoleId(Long roleId);
}
