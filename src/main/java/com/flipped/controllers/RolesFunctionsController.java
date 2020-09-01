/**
 * 
 */
package com.flipped.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.flipped.model.RolesFunctionsDTO;
import com.flipped.services.RolesFunctionsService;

/**
 * @author zz6unp
 *
 */
@RestController
@RequestMapping("/api/rolesFunctions")
public class RolesFunctionsController {
	
	@Autowired
	private RolesFunctionsService rolesFunctionsService;
	
	@GetMapping("/{id}")
	public RolesFunctionsDTO findById(@PathVariable("id") Long id) {
		return rolesFunctionsService.findById(id);
	}
	
	@GetMapping(params={ "roleId"})
	public List<RolesFunctionsDTO> findByRoleId(@RequestParam("roleId") Long roleId){
		return rolesFunctionsService.findByRoleId(roleId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody RolesFunctionsDTO rolesFunctionsDTO) {
		rolesFunctionsService.create(rolesFunctionsDTO);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody RolesFunctionsDTO rolesFunctionsDTO) {
		rolesFunctionsService.update(rolesFunctionsDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		rolesFunctionsService.delete(id);
	}
}
