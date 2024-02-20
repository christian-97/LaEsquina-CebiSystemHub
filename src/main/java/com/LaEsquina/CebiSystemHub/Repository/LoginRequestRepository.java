package com.LaEsquina.CebiSystemHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LaEsquina.CebiSystemHub.Model.LoginRequest;

public interface LoginRequestRepository extends JpaRepository<LoginRequest, Long> {
	LoginRequest findByUsername(String username);
}