package com.example.curse.repo;

import com.example.curse.model.Penalty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PenaltyService {



        private final PenaltyRepository PenaltyRepository;

    @Autowired
    public PenaltyService(PenaltyRepository PenaltyRepository) {
        this.PenaltyRepository = PenaltyRepository;
    }


    public Penalty findById(Long id) {
            return PenaltyRepository.getOne(id);
        }

        public List<Penalty> findAll() {
            return PenaltyRepository.findAll();
        }

        public Penalty savePenalty(Penalty Penalty) {
            return PenaltyRepository.save(Penalty);
        }

        public void deleteById(Long id) {
            PenaltyRepository.deleteById(id);
        }

    }

