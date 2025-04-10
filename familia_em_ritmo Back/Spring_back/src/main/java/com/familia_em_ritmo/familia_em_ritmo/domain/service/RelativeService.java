package com.familia_em_ritmo.familia_em_ritmo.domain.service;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.Relative;
import com.familia_em_ritmo.familia_em_ritmo.domain.repository.RelativeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RelativeService {
    private final RelativeRepository relativeRepository;

    public RelativeService(RelativeRepository relativeRepository) {
        this.relativeRepository = relativeRepository;
    }

    public Relative create(Relative relative){
        return relativeRepository.save(relative);
    }

    public List<Relative> getAll(){
        return relativeRepository.findAll();
    }

    public Optional<Relative> getById(Long id){
        return relativeRepository.findById(id);
    }
}
