package com.org.mayara.Escola.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.mayara.Escola.model.Curso;
import com.org.mayara.Escola.repository.CursoRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    // Add a new Curso
    public Curso adicionarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    // Get a specific Curso by ID
    public Curso obterCurso(Long cursoId) {
        return cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }

    // Update an existing Curso
    public Curso atualizarCurso(Long cursoId, Curso updatedCurso) {
        Curso curso = obterCurso(cursoId);
        curso.setNome(updatedCurso.getNome());
        curso.setDescricao(updatedCurso.getDescricao());
        return cursoRepository.save(curso);
    }

    // Delete a Curso by ID
    public void removerCurso(Long cursoId) {
        if (cursoRepository.existsById(cursoId)) {
            cursoRepository.deleteById(cursoId);
        } else {
            throw new RuntimeException("Curso não encontrado");
        }
    }
}
