package com.sorcererpaws.SpringShiro.config;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sorcererpaws.SpringShiro.entity.Role;
import com.sorcererpaws.SpringShiro.entity.User;
import com.sorcererpaws.SpringShiro.service.UserService;

@Component
public class CustomSecurityRealm extends AuthorizingRealm {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomSecurityRealm.class);
	
	@Autowired
	private UserService userService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		
		LOGGER.info("Inside doGetAuthorizationInfo()");
		Set<String> roles = new HashSet<String>();
		Set permissions = new HashSet();
		permissions.add(new WildcardPermission("*"));
		
		Collection<User> userPrincipals = principalCollection.byType(User.class);
		
		for(User user: userPrincipals) {
			
			LOGGER.info(user.getEmail());
			LOGGER.info(user.getPassword());
			
			for(Role role: user.getRoles()) {
				
				LOGGER.info(user.getName() + " is a " + role.getName());
				roles.add(role.getName());
			}
		}
		
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo(roles);
		authorizationInfo.setRoles(roles);
		authorizationInfo.setObjectPermissions(permissions);
		
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		
		LOGGER.info("inside doGetAuthenticationInfo()");
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
		
		User user = getUserService().userByEmail(usernamePasswordToken.getUsername());
		LOGGER.info("logged in user email: " + user.getEmail());
		if(user != null && user.getPassword().equals(new String(usernamePasswordToken.getPassword()))) {
			
			LOGGER.info("User authenticated");
			return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
		} else {
			
			throw new AuthenticationException("Invalid username/password combination!");
		}
	}

	//Getters and setters
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
