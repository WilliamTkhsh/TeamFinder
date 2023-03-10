package com.api.playerconnect.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.playerconnect.models.ConfirmationTokenModel;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationTokenModel, Long> {
	
	Optional<ConfirmationTokenModel> findByToken(String token);
}
