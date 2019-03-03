package com.brian.store.adminportal.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.brian.store.adminportal.domain.User;
import com.brian.store.adminportal.domain.security.UserRole;

@Service
public interface UserService {
	User createUser(User user, Set<UserRole> userRoles);

	User save(User user);
}
