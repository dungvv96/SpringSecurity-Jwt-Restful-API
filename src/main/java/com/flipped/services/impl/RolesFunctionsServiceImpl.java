/**
 * 
 */
package com.flipped.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flipped.entity.Functions;
import com.flipped.entity.Roles;
import com.flipped.entity.RolesFunctions;
import com.flipped.model.FunctionsDTO;
import com.flipped.model.RolesDTO;
import com.flipped.model.RolesFunctionsDTO;
import com.flipped.repository.RolesFunctionsRepository;
import com.flipped.services.RolesFunctionsService;

/**
 * @author zz6unp
 *
 */
@Service
@Transactional
public class RolesFunctionsServiceImpl implements RolesFunctionsService {

	@Autowired
	private RolesFunctionsRepository repository;
	
	@Override
	public void create(RolesFunctionsDTO rolesFunctionsDTO) {
		RolesFunctions rolesFunctions = new RolesFunctions();
		
		//Set role
		Roles role = new Roles();
		role.setId(rolesFunctionsDTO.getRole().getId());
		
		//Set functions
		Functions function = new Functions();
		function.setId(rolesFunctionsDTO.getFunction().getId());
		
		rolesFunctions.setRole(role);
		rolesFunctions.setFunction(function);
		rolesFunctions.setDescriptions(rolesFunctionsDTO.getDescriptions());
		rolesFunctions.setStatus(rolesFunctionsDTO.getStatus());
		rolesFunctions.setNumbers(rolesFunctionsDTO.getNumbers());
		rolesFunctions.setAuthView(rolesFunctionsDTO.isAuthView());
		rolesFunctions.setAuthUpdate(rolesFunctionsDTO.isAuthUpdate());
		rolesFunctions.setAuthCreate(rolesFunctionsDTO.isAuthCreate());
		rolesFunctions.setAuthDelete(rolesFunctionsDTO.isAuthDelete());
		repository.create(rolesFunctions);

	}

	@Override
	public void update(RolesFunctionsDTO rolesFunctionsDTO) {
		RolesFunctions rolesFunctions = repository.findById(rolesFunctionsDTO.getId());
		Roles role = new Roles();
		role.setId(rolesFunctionsDTO.getRole().getId());
		
		//Set functions
		Functions function = new Functions();
		function.setId(rolesFunctionsDTO.getFunction().getId());
		
		rolesFunctions.setRole(role);
		rolesFunctions.setFunction(function);
		rolesFunctions.setDescriptions(rolesFunctionsDTO.getDescriptions());
		rolesFunctions.setStatus(rolesFunctionsDTO.getStatus());
		rolesFunctions.setNumbers(rolesFunctionsDTO.getNumbers());
		rolesFunctions.setAuthView(rolesFunctionsDTO.isAuthView());
		rolesFunctions.setAuthUpdate(rolesFunctionsDTO.isAuthUpdate());
		rolesFunctions.setAuthCreate(rolesFunctionsDTO.isAuthCreate());
		rolesFunctions.setAuthDelete(rolesFunctionsDTO.isAuthDelete());
		repository.update(rolesFunctions);

	}

	@Override
	public void delete(Long id) {
		repository.delete(id);

	}

	@Override
	public RolesFunctionsDTO findById(Long id) {
		RolesFunctions rolesFunctions = repository.findById(id);
		RolesFunctionsDTO rolesFunctionsDTO = null;
		if(rolesFunctions != null) {
			rolesFunctionsDTO = new RolesFunctionsDTO();
			
			//Get Role
			RolesDTO rolesDTO = new RolesDTO();
			rolesDTO.setId(rolesFunctions.getRole().getId());
			rolesDTO.setRoleCode(rolesFunctions.getRole().getRoleCode());
			rolesDTO.setRoleName(rolesFunctions.getRole().getRoleName());
			rolesDTO.setDescriptions(rolesFunctions.getRole().getDescriptions());
			rolesDTO.setStatus(rolesFunctions.getRole().getStatus());
			rolesDTO.setNumbers(rolesFunctions.getRole().getNumbers());
			rolesDTO.setLeveled(rolesFunctions.getRole().getLeveled());
			rolesFunctionsDTO.setRole(rolesDTO);
			
			//Get functions
			FunctionsDTO functionsDTO = new FunctionsDTO();
			functionsDTO.setId(rolesFunctions.getFunction().getId());
			functionsDTO.setFunctionCode(rolesFunctions.getFunction().getFunctionCode());
			functionsDTO.setFunctionName(rolesFunctions.getFunction().getFunctionName());
			functionsDTO.setLinkApi(rolesFunctions.getFunction().getLinkApi());
			functionsDTO.setDescriptions(rolesFunctions.getFunction().getDescriptions());
			functionsDTO.setStatus(rolesFunctions.getFunction().getStatus());
			functionsDTO.setNumbers(rolesFunctions.getFunction().getNumbers());
			rolesFunctionsDTO.setFunction(functionsDTO);
			
			rolesFunctionsDTO.setId(id);
			rolesFunctionsDTO.setDescriptions(rolesFunctions.getDescriptions());
			rolesFunctionsDTO.setStatus(rolesFunctions.getStatus());
			rolesFunctionsDTO.setNumbers(rolesFunctions.getNumbers());
			rolesFunctionsDTO.setAuthView(rolesFunctions.isAuthView());
			rolesFunctionsDTO.setAuthCreate(rolesFunctions.isAuthCreate());
			rolesFunctionsDTO.setAuthUpdate(rolesFunctions.isAuthUpdate());
			rolesFunctionsDTO.setAuthDelete(rolesFunctions.isAuthDelete());
		}
		return rolesFunctionsDTO;
	}

	@Override
	public List<RolesFunctionsDTO> find() {
		return null;
	}

	@Override
	public List<RolesFunctionsDTO> findByRoleId(Long roleId) {
		List<RolesFunctions> listRolesFunctions = repository.findByRoleId(roleId);
		List<RolesFunctionsDTO> listRolesFunctionsDTO = new ArrayList<>();
		if(!listRolesFunctions.isEmpty()) {
			for(RolesFunctions rolesFunctions: listRolesFunctions) {
				RolesFunctionsDTO rolesFunctionsDTO = new RolesFunctionsDTO();
				
				//Get Role
				RolesDTO rolesDTO = new RolesDTO();
				rolesDTO.setId(rolesFunctions.getRole().getId());
				rolesDTO.setRoleCode(rolesFunctions.getRole().getRoleCode());
				rolesDTO.setRoleName(rolesFunctions.getRole().getRoleName());
				rolesDTO.setDescriptions(rolesFunctions.getRole().getDescriptions());
				rolesDTO.setStatus(rolesFunctions.getRole().getStatus());
				rolesDTO.setNumbers(rolesFunctions.getRole().getNumbers());
				rolesDTO.setLeveled(rolesFunctions.getRole().getLeveled());
				rolesFunctionsDTO.setRole(rolesDTO);
				
				//Get functions
				FunctionsDTO functionsDTO = new FunctionsDTO();
				functionsDTO.setId(rolesFunctions.getFunction().getId());
				functionsDTO.setFunctionCode(rolesFunctions.getFunction().getFunctionCode());
				functionsDTO.setFunctionName(rolesFunctions.getFunction().getFunctionName());
				functionsDTO.setLinkApi(rolesFunctions.getFunction().getLinkApi());
				functionsDTO.setDescriptions(rolesFunctions.getFunction().getDescriptions());
				functionsDTO.setStatus(rolesFunctions.getFunction().getStatus());
				functionsDTO.setNumbers(rolesFunctions.getFunction().getNumbers());
				rolesFunctionsDTO.setFunction(functionsDTO);
				
				rolesFunctionsDTO.setId(rolesFunctions.getId());
				rolesFunctionsDTO.setDescriptions(rolesFunctions.getDescriptions());
				rolesFunctionsDTO.setStatus(rolesFunctions.getStatus());
				rolesFunctionsDTO.setNumbers(rolesFunctions.getNumbers());
				rolesFunctionsDTO.setAuthView(rolesFunctions.isAuthView());
				rolesFunctionsDTO.setAuthCreate(rolesFunctions.isAuthCreate());
				rolesFunctionsDTO.setAuthUpdate(rolesFunctions.isAuthUpdate());
				rolesFunctionsDTO.setAuthDelete(rolesFunctions.isAuthDelete());
				listRolesFunctionsDTO.add(rolesFunctionsDTO);
			}
		}
		
		return listRolesFunctionsDTO;
	}

}
