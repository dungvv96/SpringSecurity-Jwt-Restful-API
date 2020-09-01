/**
 * 
 */
package com.flipped.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flipped.entity.Roles;
import com.flipped.model.RolesDTO;
import com.flipped.repository.RolesRepository;
import com.flipped.services.RolesService;

/**
 * @author zz6unp
 *
 */
@Service
@Transactional
public class RolesServiceImpl implements RolesService {

	@Autowired
	private RolesRepository repository;
	
	@Override
	public void create(RolesDTO rolesDTO) {
		Roles role = new Roles();
		role.setRoleCode(rolesDTO.getRoleCode());
		role.setRoleName(rolesDTO.getRoleName());
		role.setDescriptions(rolesDTO.getDescriptions());
		role.setStatus(rolesDTO.getStatus());
		role.setNumbers(rolesDTO.getNumbers());
		role.setLeveled(rolesDTO.getLeveled());
		repository.create(role);

	}

	@Override
	public void update(RolesDTO rolesDTO) {
		Roles role = repository.findById(rolesDTO.getId());
		//role.setRoleCode(rolesDTO.getRoleCode());
		role.setRoleName(rolesDTO.getRoleName());
		role.setDescriptions(rolesDTO.getDescriptions());
		role.setStatus(rolesDTO.getStatus());
		role.setNumbers(rolesDTO.getNumbers());
		role.setLeveled(rolesDTO.getLeveled());
		repository.update(role);

	}

	@Override
	public void delete(Long id) {
		repository.delete(id);

	}

	@Override
	public RolesDTO findById(Long id) {
		Roles role = repository.findById(id);
		RolesDTO rolesDTO = null;
		if(role != null) {
			rolesDTO = new RolesDTO();
			rolesDTO.setId(role.getId());
			rolesDTO.setRoleCode(role.getRoleCode());
			rolesDTO.setRoleName(role.getRoleName());
			rolesDTO.setDescriptions(role.getDescriptions());
			rolesDTO.setStatus(role.getStatus());
			rolesDTO.setNumbers(role.getNumbers());
			rolesDTO.setLeveled(role.getLeveled());
		}
		return rolesDTO;
	}

	@Override
	public RolesDTO findByRoleCode(String roleCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RolesDTO> find(String keyword) {
		List<Roles> roles = repository.find(keyword);
		List<RolesDTO> rolesDTOs = new ArrayList<>();
		if(!roles.isEmpty()) {
			for(Roles role: roles) {
				RolesDTO rolesDTO = new RolesDTO();
				rolesDTO.setId(role.getId());
				rolesDTO.setRoleCode(role.getRoleCode());
				rolesDTO.setRoleName(role.getRoleName());
				rolesDTO.setDescriptions(role.getDescriptions());
				rolesDTO.setStatus(role.getStatus());
				rolesDTO.setNumbers(role.getNumbers());
				rolesDTO.setLeveled(role.getLeveled());
				rolesDTOs.add(rolesDTO);
			}
		}
		return rolesDTOs;
	}

	@Override
	public List<RolesDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
