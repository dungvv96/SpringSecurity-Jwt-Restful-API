/**
 * 
 */
package com.flipped.services;

import java.util.List;

import com.flipped.model.UsersDTO;

/**
 * @author zz6unp
 *
 */
public interface UsersService {
	void create(UsersDTO usersDTO);
	void update(UsersDTO usersDTO);
	void delete(Long id);
	UsersDTO findById(Long id);
	UsersDTO findByUsername(String username);
	UsersDTO findByEmail(String email);
	List<UsersDTO> find(String keyword);
}
