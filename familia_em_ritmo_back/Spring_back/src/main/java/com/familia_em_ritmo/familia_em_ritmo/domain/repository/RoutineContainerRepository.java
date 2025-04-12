package com.familia_em_ritmo.familia_em_ritmo.domain.repository;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.RoutineContainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutineContainerRepository extends JpaRepository<RoutineContainer, Long> {
}
