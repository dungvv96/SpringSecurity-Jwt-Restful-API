/**
 * 
 */
package com.flipped.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flipped.model.JwtResponse;
import com.flipped.model.LoginRequest;
import com.flipped.model.MessageResponse;
import com.flipped.model.UserPrincipal;
import com.flipped.security.jwt.JwtUtils;
import com.flipped.services.AppService;

/**
 * @author zz6unp
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AppController {

	@Autowired
	private AppService appService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@GetMapping("/indexData")
	public void indexData() {
		appService.indexData();
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
		Authentication authentication = null;
		try {
			authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		}catch(Exception e) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Username or Password not correct!"));
		}
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwtToken = jwtUtils.generateJwtToken(authentication);
		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		List<SimpleGrantedAuthority> authorities = (List<SimpleGrantedAuthority>) userPrincipal.getAuthorities();
		List<String> roles = new ArrayList<>();
		for(SimpleGrantedAuthority simple: authorities) {
			roles.add(simple.getAuthority());
		}
		
		return ResponseEntity.ok(new JwtResponse(jwtToken,
				userPrincipal.getId(),
				userPrincipal.getUsername(),
				userPrincipal.getEmail(),
				roles));
	}
}
