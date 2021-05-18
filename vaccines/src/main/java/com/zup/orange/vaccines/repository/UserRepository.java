package com.zup.orange.vaccines.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.orange.vaccines.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findUserByCpf(String cpf);
	
}
