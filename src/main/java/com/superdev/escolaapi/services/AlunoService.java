package com.superdev.escolaapi.services;

import com.superdev.escolaapi.dtos.aluno.AlunoCreateDto;
import com.superdev.escolaapi.dtos.aluno.AlunoUpdateDto;
import com.superdev.escolaapi.exceptions.ResourceNotFoundException;
import com.superdev.escolaapi.models.Aluno;
import com.superdev.escolaapi.repositories.AlunoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlunoService {
    private final AlunoRepository repository;
    public AlunoService(AlunoRepository repository){this.repository = repository;}

    public List<Aluno>showAluno(){return this.repository.findAll();}

    public Aluno createAluno(AlunoCreateDto dado){
        var aluno = Aluno.builder()
                .nome(dado.nome())
                .cpf(dado.cpf())
                .dataNascimento(dado.dataNascimento())
                .build();

        if (dado.dataNascimento().isAfter(LocalDate.now().minusYears(16))) {
            throw new IllegalArgumentException(
                    "O aluno deve ter pelo menos 16 anos"
            );
        }
        return this.repository.save(aluno);

    }
    public Aluno updateAluno(int id, AlunoUpdateDto dado){
        var aluno = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Aluno with id " + id + " not found"
        ));
        aluno.setNome(dado.nome());
        aluno.setCpf(dado.cpf());
        aluno.setDataNascimento(dado.dataNascimento());

        if (dado.dataNascimento().isAfter(LocalDate.now().minusYears(16))) {
            throw new IllegalArgumentException(
                    "O aluno deve ter pelo menos 16 anos"
            );
        }

        return this.repository.save(aluno);

    }

    public Aluno showAlunoById(int id){
        var aluno = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Aluno with id " + id + " not found"
        ));
        return aluno;

    }

    public Aluno deleteAluno(int id){
        var aluno = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(
                "Aluno with id " + id + " not found "
        ));
        repository.delete(aluno);
        return aluno;
    }



}
