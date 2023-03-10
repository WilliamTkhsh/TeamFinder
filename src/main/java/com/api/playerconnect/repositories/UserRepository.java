package com.api.playerconnect.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.playerconnect.models.UserModel;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserModel, UUID> {
	Optional<UserModel> findByEmail(String email);
}
