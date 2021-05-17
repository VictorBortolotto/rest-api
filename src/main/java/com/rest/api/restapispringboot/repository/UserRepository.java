package com.rest.api.restapispringboot.repository;

import com.rest.api.restapispringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{}
