/**
 * 
 */
package com.flipped.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flipped.utils.PasswordGenerate;
import com.flipped.entity.Roles;
import com.flipped.entity.Users;
import com.flipped.model.RolesDTO;
import com.flipped.model.UsersDTO;
import com.flipped.repository.UsersRepository;
import com.flipped.services.UsersService;

/**
 * @author zz6unp
 *
 */
@Service
@Transactional
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository repository;
	
	@Override
	public void create(UsersDTO usersDTO) {
		Users user = new Users();
		user.setUsername(usersDTO.getUsername());
		user.setPassword(PasswordGenerate.getHashString(usersDTO.getPassword()));
		user.setEmail(usersDTO.getEmail());
		user.setFullname(usersDTO.getFullname());
		user.setPhoneNumber(usersDTO.getPhoneNumber());
		user.setDateCreated(new Date());
		user.setStatus(usersDTO.getStatus());
		user.setDescriptions(usersDTO.getDescriptions());
		user.setEnabled(true);
		if(usersDTO.getRole()!= null) {
			Roles role = new Roles();
			role.setId(usersDTO.getRole().getId());
			user.setRole(role);
		}
		repository.create(user);

	}

	@Override
	public void update(UsersDTO usersDTO) {
		Users user = repository.findById(usersDTO.getId());
		user.setUsername(usersDTO.getUsername());
		user.setPassword(usersDTO.getPassword());
		user.setEmail(usersDTO.getEmail());
		user.setFullname(usersDTO.getFullname());
		user.setPhoneNumber(usersDTO.getPhoneNumber());
		user.setDateCreated(new Date());
		user.setStatus(usersDTO.getStatus());
		user.setDescriptions(usersDTO.getDescriptions());
		user.setEnabled(usersDTO.isEnabled());
		if(usersDTO.getRole()!= null) {
			Roles role = new Roles();
			role.setId(usersDTO.getRole().getId());
			user.setRole(role);
		}
		repository.update(user);

	}

	@Override
	public void delete(Long id) {
		repository.delete(id);

	}

	@Override
	public UsersDTO findById(Long id) {
		Users user = repository.findById(id);
		UsersDTO usersDTO = null;
		if(user != null) {
			usersDTO = new UsersDTO();
			usersDTO.setId(id);
			usersDTO.setUsername(user.getUsername());
			usersDTO.setPassword(user.getPassword());
			usersDTO.setFullname(user.getFullname());
			usersDTO.setEmail(user.getEmail());
			usersDTO.setPhoneNumber(user.getPhoneNumber());
			usersDTO.setDescriptions(user.getDescriptions());
			usersDTO.setStatus(user.getStatus());
			usersDTO.setDateCreated(user.getDateCreated());
			usersDTO.setDateLogin(user.getDateLogin());
			usersDTO.setDateUpdated(user.getDateUpdated());
			usersDTO.setEnabled(user.isEnabled());
			//Get role
			if(user.getRole() != null) {
				RolesDTO role = new RolesDTO();
				role.setId(user.getRole().getId());
				role.setRoleCode(user.getRole().getRoleCode());
				role.setRoleName(user.getRole().getRoleName());
				role.setDescriptions(user.getRole().getDescriptions());
				role.setStatus(user.getRole().getStatus());
				role.setLeveled(user.getRole().getLeveled());
				role.setNumbers(user.getRole().getNumbers());
				usersDTO.setRole(role);
			}
		}
		return usersDTO;
	}

	@Override
	public UsersDTO findByUsername(String username) {
		Users user = repository.findByUsername(username);
		UsersDTO usersDTO = null;
		if(user != null) {
			usersDTO = new UsersDTO();
			usersDTO.setId(user.getId());
			usersDTO.setUsername(user.getUsername());
			usersDTO.setPassword(user.getPassword());
			usersDTO.setFullname(user.getFullname());
			usersDTO.setEmail(user.getEmail());
			usersDTO.setPhoneNumber(user.getPhoneNumber());
			usersDTO.setDescriptions(user.getDescriptions());
			usersDTO.setStatus(user.getStatus());
			usersDTO.setDateCreated(user.getDateCreated());
			usersDTO.setDateLogin(user.getDateLogin());
			usersDTO.setDateUpdated(user.getDateUpdated());
			usersDTO.setEnabled(user.isEnabled());
			//Get Role
			if(user.getRole() != null) {
				RolesDTO role = new RolesDTO();
				role.setId(user.getRole().getId());
				role.setRoleCode(user.getRole().getRoleCode());
				role.setRoleName(user.getRole().getRoleName());
				role.setDescriptions(user.getRole().getDescriptions());
				role.setStatus(user.getRole().getStatus());
				role.setLeveled(user.getRole().getLeveled());
				role.setNumbers(user.getRole().getNumbers());
				usersDTO.setRole(role);
			}
		}
		return usersDTO;
	}

	@Override
	public UsersDTO findByEmail(String email) {
		Users user = repository.findByEmail(email);
		UsersDTO usersDTO = null;
		if(user != null) {
			usersDTO = new UsersDTO();
			usersDTO.setId(user.getId());
			usersDTO.setUsername(user.getUsername());
			usersDTO.setPassword(user.getPassword());
			usersDTO.setFullname(user.getFullname());
			usersDTO.setEmail(user.getEmail());
			usersDTO.setPhoneNumber(user.getPhoneNumber());
			usersDTO.setDescriptions(user.getDescriptions());
			usersDTO.setStatus(user.getStatus());
			usersDTO.setDateCreated(user.getDateCreated());
			usersDTO.setDateLogin(user.getDateLogin());
			usersDTO.setDateUpdated(user.getDateUpdated());
			usersDTO.setEnabled(user.isEnabled());
			//Get Role
			if(user.getRole() != null) {
				RolesDTO role = new RolesDTO();
				role.setId(user.getRole().getId());
				role.setRoleCode(user.getRole().getRoleCode());
				role.setRoleName(user.getRole().getRoleName());
				role.setDescriptions(user.getRole().getDescriptions());
				role.setStatus(user.getRole().getStatus());
				role.setLeveled(user.getRole().getLeveled());
				role.setNumbers(user.getRole().getNumbers());
				usersDTO.setRole(role);
			}
		}
		return usersDTO;
	}

	@Override
	public List<UsersDTO> find(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
