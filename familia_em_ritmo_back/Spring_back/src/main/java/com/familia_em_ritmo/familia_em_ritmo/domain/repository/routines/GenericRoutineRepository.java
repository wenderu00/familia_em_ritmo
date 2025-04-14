package com.familia_em_ritmo.familia_em_ritmo.domain.repository.routines;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.routines.GenericRoutine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericRoutineRepository extends JpaRepository<GenericRoutine, Long> {
}
