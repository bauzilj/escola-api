package com.superdev.escolaapi.services;

import com.superdev.escolaapi.dtos.professor.ProfessorCreateDto;
import com.superdev.escolaapi.dtos.professor.ProfessorUpdateDto;
import com.superdev.escolaapi.exceptions.ResourceNotFoundException;
import com.superdev.escolaapi.models.Professor;
import com.superdev.escolaapi.repositories.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    private final ProfessorRepository repository;

    public ProfessorService(ProfessorRepository repository){
        this.repository = repository;
    }

    public List<Professor>showProfessor(){
        return this.repository.findAll();
    }

    public Professor createProfessor(ProfessorCreateDto dado){
        var professor = Professor.builder()
                .nome(dado.nome())
                .professorStatus(dado.professorStatus())
                .build();
        return  this.repository.save(professor);
    }
    public Professor showProfessorById(Long id){
        var professor = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(
                "Professor with id" + id + " not found"
        ));
        return professor;
    }

    public Professor updateProfessor(Long id, ProfessorUpdateDto dado){
        var professor = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Professor with id " + id + " not found"
        ));

        professor.setNome(dado.nome());
        professor.setProfessorStatus(dado.professorStatus());

        return this.repository.save(professor);
    }

    public Professor deleteProfessor(Long id){
        var professor = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Professor with id " + id + " not found"
        ));
        repository.delete(professor);
        return professor;
    }
}
