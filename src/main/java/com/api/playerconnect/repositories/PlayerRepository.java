package com.api.playerconnect.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.playerconnect.models.PlayerModel;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerModel, Long>{
	
}
