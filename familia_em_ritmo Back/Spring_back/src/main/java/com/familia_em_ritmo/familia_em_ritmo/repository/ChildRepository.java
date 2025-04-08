package com.familia_em_ritmo.familia_em_ritmo.repository;

import com.familia_em_ritmo.familia_em_ritmo.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {
}
