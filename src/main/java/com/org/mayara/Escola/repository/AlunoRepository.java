package com.org.mayara.Escola.repository;

import org.springframework.data.repository.CrudRepository;

import com.org.mayara.Escola.model.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {
}