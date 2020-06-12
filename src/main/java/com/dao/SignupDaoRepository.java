package com.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface SignupDaoRepository extends JpaRepository<UserEntity, Integer> {
	public Optional<UserEntity> findByUsernameAndPassword(String username,String password);
	public List<UserEntity> findByName(String name);


}
