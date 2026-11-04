package com.superdev.escolaapi.dtos.turma;

import com.superdev.escolaapi.enums.TurmaStatus;
import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TurmaResponseDTO {

    private Long id;

    private Long professorId;

    private String professorNome;

    private Long unidadeId;

    private String unidadeNome;

    private String nome;

    private TurmaStatus status;

    private Integer cargaHoraria;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;
}
