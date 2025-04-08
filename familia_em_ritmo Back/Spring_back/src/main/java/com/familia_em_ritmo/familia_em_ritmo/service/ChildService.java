package com.familia_em_ritmo.familia_em_ritmo.service;

import com.familia_em_ritmo.familia_em_ritmo.model.Child;
import com.familia_em_ritmo.familia_em_ritmo.repository.ChildRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildService {
    private ChildRepository childRepository;

    public ChildService(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    public Child create(Child child){
        return this.childRepository.save(child);
    }

    public List<Child> getAll(){
        return this.childRepository.findAll();
    }
}
