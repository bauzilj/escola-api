package com.superdev.escolaapi.controllers;

import com.superdev.escolaapi.dtos.unidade.UnidadeCreateDto;
import com.superdev.escolaapi.dtos.unidade.UnidadeUpdateDto;
import com.superdev.escolaapi.models.Unidade;
import com.superdev.escolaapi.services.UnidadeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/unidades")
public class UnidadeController {
    private final UnidadeService service;

    public UnidadeController(UnidadeService service){
        this.service = service;
    }

    @GetMapping
    public List<Unidade>showUnidade(){ return  service.showUnidade();}

    @PostMapping
    public Unidade createUnidade(@RequestBody @Valid UnidadeCreateDto dto){
        return service.createUnidade(dto);
    }

    @PutMapping("/{id}")
    public Unidade updateUnidade(@PathVariable Long id, @RequestBody @Valid UnidadeUpdateDto dto){
        return service.updateUnidade(id,dto);
    }
    @GetMapping("/{id}")
    public Unidade showById(@PathVariable Long id){
        return service.showById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Unidade deleteUnidade(@PathVariable Long id){return service.deleteUnidade(id);}


}
