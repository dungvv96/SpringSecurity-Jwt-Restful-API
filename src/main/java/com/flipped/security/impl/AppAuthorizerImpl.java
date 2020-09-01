/**
 * 
 */
package com.flipped.security.impl;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ResolvableType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flipped.security.AppAuthorizer;

/**
 * @author zz6unp
 *
 */
@Service("appAuthorizer")
public class AppAuthorizerImpl implements AppAuthorizer {

	private static final Logger logger = LoggerFactory.getLogger(AppAuthorizerImpl.class);
	
	@Override
	public boolean authorizer(Authentication authentication, String action, Object callerObj) {
		String securedPath = extractSecuredPath(callerObj);
		if(securedPath == null || "".equals(securedPath.trim())) {//Login, Logout
			return true;
		}
		String menuCode = securedPath.substring(1);
		boolean isAllow = false;
		try {
			UsernamePasswordAuthenticationToken user = (UsernamePasswordAuthenticationToken) authentication;
			if(user == null) {
				return isAllow;
			}
			//test
			isAllow = true;
		}catch(Exception e) {
			logger.error(e.toString(),e.getMessage());
			throw e;
		}
		return isAllow;
	}

	public String extractSecuredPath(Object callerObj) {
		Class<?> clazz = ResolvableType.forClass(callerObj.getClass()).getRawClass();
		Optional<Annotation> annotation = Arrays.asList(clazz.getAnnotations()).stream().filter((ann) -> {
			return ann instanceof RequestMapping;
		}).findFirst();
		logger.debug("FOUND CALLER CLASS: {}", ResolvableType.forClass(callerObj.getClass()).getType().getTypeName());
		if(annotation.isPresent()) {
			return ((RequestMapping) annotation.get()).value()[0];
		}
		return null;
	}
}
