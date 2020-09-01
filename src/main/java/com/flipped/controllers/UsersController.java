/**
 * 
 */
package com.flipped.controllers;

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

import com.flipped.model.UsersDTO;
import com.flipped.services.UsersService;

/**
 * @author zz6unp
 *
 */
@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('Administrator')")
	public UsersDTO findById(@PathVariable("id") Long id) {
		return usersService.findById(id);
	}
	
	@GetMapping(params={ "username"})
	public UsersDTO findByUsername(@RequestParam("username") String username) {
		return usersService.findByUsername(username);
	}
	
	@GetMapping(params={ "email"})
	public UsersDTO findByEmail(@RequestParam("email") String email) {
		return usersService.findByUsername(email);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody UsersDTO usersDTO) {
		usersService.create(usersDTO);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody UsersDTO usersDTO) {
		usersService.update(usersDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		usersService.delete(id);
	}
}
