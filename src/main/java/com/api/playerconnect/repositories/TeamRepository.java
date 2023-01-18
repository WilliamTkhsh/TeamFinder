package com.api.playerconnect.repositories;

import com.api.playerconnect.models.TeamModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface TeamRepository extends JpaRepository<TeamModel, UUID> {

}
