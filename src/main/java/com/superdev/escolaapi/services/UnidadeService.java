package com.superdev.escolaapi.services;

import com.superdev.escolaapi.dtos.unidade.UnidadeCreateDto;
import com.superdev.escolaapi.dtos.unidade.UnidadeUpdateDto;
import com.superdev.escolaapi.exceptions.ResourceNotFoundException;
import com.superdev.escolaapi.models.Unidade;
import com.superdev.escolaapi.repositories.UnidadeRepository;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class UnidadeService {
    private final UnidadeRepository repository;

    public UnidadeService(UnidadeRepository repository){
        this.repository = repository;
    }
    public List<Unidade>showUnidade(){return this.repository.findAll();}

    public Unidade createUnidade(UnidadeCreateDto dado){
        var unidade = Unidade.builder()
                .nome(dado.nome())
                .sigla(dado.sigla())
                .build();
        return this.repository.save(unidade);
    }

    public Unidade updateUnidade(int id, UnidadeUpdateDto dado){
        var unidade = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Unidade with id " + id + " not found"
        ));

        unidade.setNome(dado.nome());
        unidade.setSigla(dado.sigla());

        return this.repository.save(unidade);
    }

    public Unidade showById(int id){
        var unidade = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Unidade with id " + id + " not found"
        ) ) ;
        return unidade;
    }

    public Unidade deleteUnidade(int id){
        var unidade = repository.findById(id).orElseThrow();

        repository.delete(unidade);
        return unidade;
    }
}
