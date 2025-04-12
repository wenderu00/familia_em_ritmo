package com.familia_em_ritmo.familia_em_ritmo.domain.repository.routines;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.routines.FeedingRoutine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedingRoutineRepository extends JpaRepository<FeedingRoutine, Long> {
}
