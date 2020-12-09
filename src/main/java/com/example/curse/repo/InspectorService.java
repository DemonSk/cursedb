package com.example.curse.repo;

import com.example.curse.model.Inspector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InspectorService {

    private final InspectorRepository inspectorRepository;

    @Autowired
    public InspectorService(InspectorRepository inspectorRepository) {
        this.inspectorRepository = inspectorRepository;
    }


    public Inspector findById(Long id) {
        return inspectorRepository.getOne(id);
    }

    public List<Inspector> findAll() {
        return inspectorRepository.findAll();
    }

    public Inspector saveInspector(Inspector Inspector) {
        return inspectorRepository.save(Inspector);
    }

    public void deleteById(Long id) {
        inspectorRepository.deleteById(id);
    }

}