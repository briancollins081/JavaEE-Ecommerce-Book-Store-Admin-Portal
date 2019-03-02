package com.brian.store.adminportal.repository;

import com.brian.store.adminportal.domain.User;
import org.springframework.data.repository.CrudRepository;;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);
}
