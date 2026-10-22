package com.superdev.escolaapi.dtos.professor;

import com.superdev.escolaapi.enums.ProfessorStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProfessorUpdateDto(
        @Schema(description = "Define o nome do professor", example = "Jean Joseph Bauzil")
        @NotBlank @Size(min = 3, max = 150)
        String nome,

        @Schema(description = "Define o status como: ATIVO ou INATIVO", example = "ATIVO")
        ProfessorStatus professorStatus
) {
}
