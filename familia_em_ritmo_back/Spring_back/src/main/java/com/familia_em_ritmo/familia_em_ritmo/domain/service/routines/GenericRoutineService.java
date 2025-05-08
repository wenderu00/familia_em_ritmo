package com.familia_em_ritmo.familia_em_ritmo.domain.service.routines;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.routines.GenericRoutine;
import com.familia_em_ritmo.familia_em_ritmo.domain.repository.routines.GenericRoutineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericRoutineService {
    private GenericRoutineRepository genericRoutineRepository;

    public List<GenericRoutine> getAllByChild(Long id){
        return this.genericRoutineRepository.findAll()
                .stream()
                .filter(genericRoutine -> genericRoutine.getRoutineContainer().getChild().getId() == id)
                .toList();
    }

    public GenericRoutine createRoutine(GenericRoutine routine){
        return this.genericRoutineRepository.save(routine);
    }

    public GenericRoutine getById(Long id){
        return this.genericRoutineRepository.findById(id).get();
    }

    public void remove(Long id){
        this.genericRoutineRepository.delete(this.genericRoutineRepository.findById(id).get());
    }
}
