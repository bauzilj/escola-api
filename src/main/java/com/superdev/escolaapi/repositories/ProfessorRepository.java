package com.superdev.escolaapi.repositories;

import com.superdev.escolaapi.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
