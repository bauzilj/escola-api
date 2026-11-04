package com.superdev.escolaapi.controllers;

import com.superdev.escolaapi.dtos.turma.TurmaRequestDTO;
import com.superdev.escolaapi.dtos.turma.TurmaResponseDTO;
import com.superdev.escolaapi.models.Turma;
import com.superdev.escolaapi.services.TurmaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/turmas")
public class TurmaController {

    private final TurmaService service;

    public TurmaController(TurmaService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TurmaResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public Turma createTurma(@RequestBody @Valid TurmaRequestDTO dto){
        return  service.createTurma(dto);
    }
}
