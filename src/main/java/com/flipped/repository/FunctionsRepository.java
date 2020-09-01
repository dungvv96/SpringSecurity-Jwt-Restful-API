/**
 * 
 */
package com.flipped.repository;

import java.util.List;

import com.flipped.entity.Functions;

/**
 * @author zz6unp
 *
 */
public interface FunctionsRepository {
	void create(Functions function);
	void update(Functions function);
	void delete(Long id);
	List<Functions> findAll();
	Functions findById(Long id);
	Functions findByFunctionCode(String functionCode);
	List<Functions> find(String keyword);
}
