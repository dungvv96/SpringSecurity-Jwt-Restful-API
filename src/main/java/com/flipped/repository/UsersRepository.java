/**
 * 
 */
package com.flipped.repository;

import java.util.List;

import com.flipped.entity.Users;

/**
 * @author zz6unp
 *
 */
public interface UsersRepository {
	void create(Users user);
	void update(Users user);
	void delete(Long id);
	Users findById(Long id);
	Users findByUsername(String username);
	Users findByEmail(String email);
	List<Users> find();
}
