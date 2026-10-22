package com.superdev.escolaapi.dtos.aluno;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.time.LocalDate;


public record AlunoCreateDto(
        @Schema(description = "Define o nome do aluno", example = "Jean Joseph Bauzil")
        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 3, max = 150)
        String nome,

        @Schema(description = "Define O CPF (deve conter exatamente 11 dígitos)", example = "002.345.008-00")
        @NotBlank(message = "O CPF é obrigatório")
        @Pattern( regexp = "\\d{11}",
                message = "O CPF deve conter exatamente 11 dígitos.")
        String cpf,

        @Schema(description = "Define a data de nascimento", example = "2026-10-13")
        @NotNull(message = "A data de nascimento é obrigatória")
        @Past(message = "A data de nascimento deve estar no passado")
        LocalDate dataNascimento

) {
}
