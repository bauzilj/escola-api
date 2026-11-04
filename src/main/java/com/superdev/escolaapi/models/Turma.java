package com.superdev.escolaapi.models;

import com.superdev.escolaapi.enums.TurmaStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;

@Builder
@Entity
@Table(
        name = "turmas",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_turmas_nome_unidade",
                        columnNames = {"nome", "id_unidade"}
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_professor", nullable = false)
    private Professor professor;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "id_unidade",
            nullable = false,
            updatable = false
    )
    private Unidade unidade;

    @NotBlank
    @Size(max = 120)
    
    @Column(name = "nome", nullable = false, length = 120)
    private String nome;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TurmaStatus status = TurmaStatus.ATIVA;

    @NotNull
    @Min(1)
    @Max(9999)
    @Column(name = "carga_horaria", nullable = false)
    private Integer cargaHoraria;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    @PrePersist
    protected void prePersist() {
        if (status == null) {
            status = TurmaStatus.ATIVA;
        }
    }

}
