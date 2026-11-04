package com.superdev.escolaapi.dtos.turma;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TurmaRequestDTO(

        @Schema(description = "Define o ID do professor", example = "3")
        @NotNull(message = "Professor ID is required")
        @Min(value = 1, message = "Professor ID must be greater than zero")
        Long professorId,

        @Schema(description = "Define o ID da unidade", example ="2" )
        @NotNull(message = "Unidade ID is required")
        @Min(value = 1, message = "Unidade ID must be greater than zero")
        Long unidadeId,

        @Schema(description = "Define o nome", example = "Jean Joseph Bauzil")
        @NotBlank(message = "Class name is required")
        String nome,

        @Schema(description = "Define o Status", example = "ATIVA")
        @NotBlank(message = "Status is required")
        String status,

        @Schema(description = "Define a carga horaria     hora", example = "80")
        @NotNull(message = "Workload is required")
        @Min(value = 1, message = "Workload must be greater than zero")
        Integer cargaHoraria

) {}
