package com.superdev.escolaapi.services;

import com.superdev.escolaapi.dtos.turma.TurmaRequestDTO;
import com.superdev.escolaapi.dtos.turma.TurmaResponseDTO;
import com.superdev.escolaapi.models.Professor;
import com.superdev.escolaapi.models.Turma;
import com.superdev.escolaapi.models.Unidade;
import com.superdev.escolaapi.repositories.ProfessorRepository;
import com.superdev.escolaapi.repositories.TurmaRepository;
import com.superdev.escolaapi.repositories.UnidadeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TurmaService {

    private final TurmaRepository repository;
    private final ProfessorRepository professorRepository;
    private final UnidadeRepository unidadeRepository;

    public TurmaService(TurmaRepository repository, ProfessorRepository professorRepository, UnidadeRepository unidadeRepository){this.repository = repository;
        this.professorRepository = professorRepository; this.unidadeRepository = unidadeRepository;
    }

    @Transactional(readOnly = true)
    public List<TurmaResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(turma -> TurmaResponseDTO.builder()
                        .id(turma.getId())
                        .professorId(turma.getProfessor().getId())
                        .professorNome(turma.getProfessor().getNome())
                        .unidadeId(turma.getUnidade().getId())
                        .unidadeNome(turma.getUnidade().getNome())
                        .nome(turma.getNome())
                        .status(turma.getStatus())
                        .cargaHoraria(turma.getCargaHoraria())
                        .createdAt(turma.getCreatedAt())
                        .updatedAt(turma.getUpdatedAt())
                        .build())
                .toList();
    }


    public Turma createTurma(TurmaRequestDTO request) {

        Professor professor = professorRepository.findById(request.professorId())
                .orElseThrow(() -> new RuntimeException("Professor not found"));

        Unidade unidade = unidadeRepository.findById(request.unidadeId())
                .orElseThrow(() -> new RuntimeException("Unidade not found"));

        var turma = Turma.builder()
                .professor(professor)
                .unidade(unidade)
                .nome(request.nome())
                .cargaHoraria(request.cargaHoraria())
                .build();

        return this.repository.save(turma);
    }

}
