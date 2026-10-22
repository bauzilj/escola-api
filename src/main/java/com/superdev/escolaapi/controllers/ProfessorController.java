package com.superdev.escolaapi.controllers;


import com.superdev.escolaapi.dtos.professor.ProfessorCreateDto;
import com.superdev.escolaapi.dtos.professor.ProfessorUpdateDto;
import com.superdev.escolaapi.models.Professor;
import com.superdev.escolaapi.services.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    private  final ProfessorService service;
    public ProfessorController(ProfessorService service){this.service = service;}

    @GetMapping
    public List<Professor>showProfessor() {
        return service.showProfessor();
    }

    @PostMapping
    public Professor createProfessor(@RequestBody @Valid ProfessorCreateDto dto){
        return service.createProfessor(dto);
    }

    @GetMapping("/{id}")
    public Professor showProfessorById(@PathVariable int id){
        return service.showProfessorById(id);
    }

    @PutMapping("/{id}")
    public Professor updateProfessor(@PathVariable int id, @RequestBody @Valid ProfessorUpdateDto dto){
        return  service.updateProfessor(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Professor deleteProfessor(@PathVariable int id){
        return  service.deleteProfessor(id);
    }
}

