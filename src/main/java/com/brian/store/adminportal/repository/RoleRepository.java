package com.brian.store.adminportal.repository;

import org.springframework.data.repository.CrudRepository;

import com.brian.store.adminportal.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

	Role findByName(String name);
}
