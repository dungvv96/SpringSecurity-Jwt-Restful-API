/**
 * 
 */
package com.flipped.security;

import org.springframework.security.core.Authentication;

/**
 * @author zz6unp
 *
 */
public interface AppAuthorizer {
	boolean authorizer(Authentication authentication,String action,Object callerObj);
}
