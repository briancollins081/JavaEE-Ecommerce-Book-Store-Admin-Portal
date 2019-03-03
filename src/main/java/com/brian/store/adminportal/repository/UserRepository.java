package com.brian.store.adminportal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brian.store.adminportal.domain.User;;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);
}
