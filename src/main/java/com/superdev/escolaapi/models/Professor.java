package com.superdev.escolaapi.models;

import com.superdev.escolaapi.enums.ProfessorStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "professores")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 150, nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private ProfessorStatus professorStatus;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name="updated_at", nullable = false, updatable = false)
    private  LocalDateTime updatedAt;

    @PrePersist
    void aoCriar(){
        LocalDateTime agora = LocalDateTime.now();
        if (createdAt == null){createdAt = agora;}
        if (updatedAt == null){updatedAt = agora;}

    }
}
