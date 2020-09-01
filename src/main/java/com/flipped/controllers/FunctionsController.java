/**
 * 
 */
package com.flipped.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.flipped.model.FunctionsDTO;
import com.flipped.services.FunctionsService;

/**
 * @author zz6unp
 *
 */
@RestController
@RequestMapping("/api/functions")
public class FunctionsController {

	@Autowired
	private FunctionsService functionsService;
	
	@GetMapping
	public List<FunctionsDTO> findAll(){
		return functionsService.findAll();
	}
	
	@GetMapping(params={ "keyword"})
	@PreAuthorize("@appAuthorizer.authorizer(authentication, 'VIEW', this)")
	public List<FunctionsDTO> find(@RequestParam("keyword") String keyword){
		return functionsService.find(keyword);
	}
	
	@GetMapping(value="/{id}")
	@PreAuthorize("hasRole('Staff')")
	public FunctionsDTO findById(@PathVariable("id") Long id) {
		return functionsService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody FunctionsDTO functionsDTO) {
		functionsService.create(functionsDTO);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable("id") Long id, @RequestBody FunctionsDTO functionsDTO) {
		functionsService.update(functionsDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		functionsService.delete(id);
	}
}
