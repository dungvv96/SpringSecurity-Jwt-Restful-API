/**
 * 
 */
package com.flipped.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.flipped.model.RolesDTO;
import com.flipped.services.RolesService;

/**
 * @author zz6unp
 *
 */
@RestController
@RequestMapping("/api/roles")
public class RolesController {
	@Autowired
	private RolesService rolesService;
	
	@GetMapping
	public List<RolesDTO> findAll(){
		return rolesService.findAll();
	}
	
	@GetMapping(params={ "keyword"})
	public List<RolesDTO> find(@RequestParam("keyword") String keyword){
		return rolesService.find(keyword);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<RolesDTO> findById(@PathVariable("id") Long id){
		RolesDTO rolesDTO = rolesService.findById(id);
		return ResponseEntity.ok().body(rolesDTO);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody RolesDTO rolesDTO) {
		rolesService.create(rolesDTO);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody RolesDTO rolesDTO) {
		rolesService.update(rolesDTO);
	}
	
	@DeleteMapping(value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		rolesService.delete(id);
	}
}
