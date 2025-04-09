package com.familia_em_ritmo.familia_em_ritmo.repository;

import com.familia_em_ritmo.familia_em_ritmo.model.Relative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RelativeRepository extends JpaRepository<Relative, Long> {
}
