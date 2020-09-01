/**
 * 
 */
package com.flipped.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flipped.entity.Users;
import com.flipped.model.UserPrincipal;
import com.flipped.repository.UsersRepository;

/**
 * @author zz6unp
 *
 */
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = usersRepository.findByUsername(username);
		if(user == null) {
			user = usersRepository.findByEmail(username);
			if(user == null) {
				throw new UsernameNotFoundException("User not found!");
			}
		}
		return UserPrincipal.build(user);
	}

}
