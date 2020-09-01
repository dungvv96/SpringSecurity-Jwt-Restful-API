/**
 * 
 */
package com.flipped.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flipped.entity.Users;

/**
 * @author zz6unp
 *
 */
public class UserPrincipal implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	
	private String username;
	
	@JsonIgnore
	private String password;
	
	private String email;
	
	private boolean enabled;
	
	private Collection<? extends GrantedAuthority> authorities;

	public UserPrincipal(Long id, String username,String email, String password, boolean enabled,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.authorities = authorities;
	}
	
	public static UserPrincipal build(Users user) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
		return new UserPrincipal(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(),user.isEnabled(), authorities);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
	
		

}
