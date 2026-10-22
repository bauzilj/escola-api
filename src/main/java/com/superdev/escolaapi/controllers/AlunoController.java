package com.superdev.escolaapi.controllers;

import com.superdev.escolaapi.dtos.aluno.AlunoCreateDto;
import com.superdev.escolaapi.dtos.aluno.AlunoUpdateDto;
import com.superdev.escolaapi.dtos.professor.ProfessorUpdateDto;
import com.superdev.escolaapi.models.Aluno;
import com.superdev.escolaapi.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService service;
    public  AlunoController(AlunoService service){this.service = service;}

    @GetMapping
    public List<Aluno>showAluno(){return service.showAluno();}

    @PostMapping
    public Aluno createAluno(@RequestBody @Valid AlunoCreateDto dto){

        return  service.createAluno(dto);
    }

    @PutMapping("/{id}")
    public  Aluno updateAluno(@PathVariable int id, @RequestBody @Valid AlunoUpdateDto dto){
       return service.updateAluno(id, dto);
    }

    @GetMapping("/{id}")
    public Aluno showAlunoById(@PathVariable int id){
        return  service.showAlunoById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Aluno deleteAluno( @PathVariable int id){ return service.deleteAluno(id);}

}
