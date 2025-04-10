package com.familia_em_ritmo.familia_em_ritmo.domain.repository;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.Relative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelativeRepository extends JpaRepository<Relative, Long> {
}
