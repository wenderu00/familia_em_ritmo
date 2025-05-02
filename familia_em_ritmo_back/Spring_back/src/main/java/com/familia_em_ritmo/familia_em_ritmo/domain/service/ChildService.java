package com.familia_em_ritmo.familia_em_ritmo.domain.service;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.Child;
import com.familia_em_ritmo.familia_em_ritmo.domain.repository.ChildRepository;
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

    public Child getById(Long id){
        return childRepository.findById(id).get();
    }

    public void remove(Long id){
        Child child = this.childRepository.getReferenceById(id);
        this.childRepository.delete(child);
    }
}
