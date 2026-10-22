package com.superdev.escolaapi.dtos.unidade;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UnidadeUpdateDto(
        @Schema(description = "Define o nome da unidade", example = "Unidade de tal")
        @NotBlank @Size(min=3, max=120)
        String nome,

        @Schema(description = "Define a sigla", example = "SC")
        @NotBlank @Size(min = 2, max = 10)
        String sigla
) {
}
