/**
 * 
 */
package com.flipped.services;

import java.util.List;

import com.flipped.model.FunctionsDTO;

/**
 * @author zz6unp
 *
 */
public interface FunctionsService {
	void create(FunctionsDTO functionsDTO);
	void update(FunctionsDTO functionsDTO);
	void delete(Long id);
	FunctionsDTO findById(Long id);
	FunctionsDTO findByFunctionCode(String functionCode);
	List<FunctionsDTO> findAll();
	List<FunctionsDTO> find(String keyword);
}
