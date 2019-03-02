package com.brian.store.adminportal.service;

import java.util.Set;

import com.brian.store.adminportal.domain.User;
import com.brian.store.adminportal.domain.security.PasswordResetToken;
import com.brian.store.adminportal.domain.security.UserRole;


public interface UserService {
	User createUser(User user, Set<UserRole> userRoles);

	User save(User user);
}
