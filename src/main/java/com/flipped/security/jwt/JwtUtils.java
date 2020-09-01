/**
 * 
 */
package com.flipped.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.flipped.model.UserPrincipal;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * @author zz6unp
 *
 */
@Component
public class JwtUtils {

	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
	
	@Value("${flipped.app.jwtSecret}")
	private String jwtSecret;
	
	@Value("${flipped.app.jwtExpirationMs}")
	private int jwtExpirationMs;
	
	public String generateJwtToken(Authentication anthentication) {
		UserPrincipal userPrincipal = (UserPrincipal) anthentication.getPrincipal();
		return Jwts.builder()
				.setSubject(userPrincipal.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}
	
	public String getUsernamFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}
	
	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		}catch(SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		}catch(MalformedJwtException e) {
			logger.error("Invalid JWT token: {}",e.getMessage());
		}catch(ExpiredJwtException e) {
			logger.error("Token is expired: {}", e.getMessage());
		}catch(UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}",e.getMessage());
		}catch(IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}",e.getMessage());
		}
		return false;
	}
}
