package com.familia_em_ritmo.familia_em_ritmo.domain.repository.missions;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.missions.BehavioralMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BehavioralMissionRepository extends JpaRepository<BehavioralMission, Long> {
}
