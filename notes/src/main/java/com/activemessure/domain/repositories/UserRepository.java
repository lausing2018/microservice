package com.activemessure.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.activemessure.persistence.entities.test.User;

public interface UserRepository extends CrudRepository<User, String>{

}
