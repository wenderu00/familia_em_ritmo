package com.familia_em_ritmo.familia_em_ritmo.domain.service.routines;

import com.familia_em_ritmo.familia_em_ritmo.domain.model.routines.BehavioralRoutine;
import com.familia_em_ritmo.familia_em_ritmo.domain.repository.routines.BehavioralRoutineRepository;
import org.springframework.stereotype.Service;

@Service
public class BehavioralRoutineService {
    private final BehavioralRoutineRepository behavioralRoutineRepository;

    public BehavioralRoutineService(BehavioralRoutineRepository behavioralRoutineRepository) {
        this.behavioralRoutineRepository = behavioralRoutineRepository;
    }

    public BehavioralRoutine getBehavioralRoutineById(Long id){
        return this.behavioralRoutineRepository.findById(id).get();
    }
}
