package com.org.mayara.Escola.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.mayara.Escola.model.Aluno;
import com.org.mayara.Escola.model.Curso;
import com.org.mayara.Escola.repository.AlunoRepository;
import com.org.mayara.Escola.repository.CursoRepository;

import java.util.Optional;
import java.util.Set; // Ensure this import is present

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public void matricularAlunoEmCurso(Long alunoId, Long cursoId) {
        Optional<Aluno> alunoOpt = alunoRepository.findById(alunoId);
        Optional<Curso> cursoOpt = cursoRepository.findById(cursoId);

        if (alunoOpt.isPresent() && cursoOpt.isPresent()) {
            Aluno aluno = alunoOpt.get();
            Curso curso = cursoOpt.get();

            aluno.getCursos().add(curso);
            curso.getAlunos().add(aluno);

            alunoRepository.save(aluno);
            cursoRepository.save(curso);
        } else {
            throw new RuntimeException("Aluno ou Curso não encontrado");
        }
    }

    public void removerAlunoDeCurso(Long alunoId, Long cursoId) {
        Optional<Aluno> alunoOpt = alunoRepository.findById(alunoId);
        Optional<Curso> cursoOpt = cursoRepository.findById(cursoId);

        if (alunoOpt.isPresent() && cursoOpt.isPresent()) {
            Aluno aluno = alunoOpt.get();
            Curso curso = cursoOpt.get();

            aluno.getCursos().remove(curso);
            curso.getAlunos().remove(aluno);

            alunoRepository.save(aluno);
            cursoRepository.save(curso);
        } else {
            throw new RuntimeException("Aluno ou Curso não encontrado");
        }
    }

    public Set<Curso> listarCursosDeAluno(Long alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        return aluno.getCursos();
    }

    public Set<Aluno> listarAlunosDeCurso(Long cursoId) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        return curso.getAlunos();
    }

}
