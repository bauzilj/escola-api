package com.superdev.escolaapi.repositories;

import com.superdev.escolaapi.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
