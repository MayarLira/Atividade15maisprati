package com.org.mayara.Escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.org.mayara.Escola.model.Aluno;
import com.org.mayara.Escola.model.Curso;
import com.org.mayara.Escola.service.AlunoService;
import com.org.mayara.Escola.service.CursoService;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class AlunoCursoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private CursoService cursoService;

    
    @PostMapping("/alunos/{alunoId}/cursos/{cursoId}")
    public void matricularAlunoEmCurso(@PathVariable Long alunoId, @PathVariable Long cursoId) {
        alunoService.matricularAlunoEmCurso(alunoId, cursoId);
    }

    
    @DeleteMapping("/alunos/{alunoId}/cursos/{cursoId}")
    public void removerAlunoDeCurso(@PathVariable Long alunoId, @PathVariable Long cursoId) {
        alunoService.removerAlunoDeCurso(alunoId, cursoId);
    }

    
    @GetMapping("/alunos/{alunoId}/cursos")
    public Set<Curso> listarCursosDeAluno(@PathVariable Long alunoId) {
        return alunoService.listarCursosDeAluno(alunoId);
    }

    
    @GetMapping("/cursos/{cursoId}/alunos")
    public Set<Aluno> listarAlunosDeCurso(@PathVariable Long cursoId) {
        return alunoService.listarAlunosDeCurso(cursoId);
    }

     @PostMapping("/cursos")
     public Curso adicionarCurso(@RequestBody Curso curso) {
         return cursoService.adicionarCurso(curso);
     }
 
     @GetMapping("/cursos/{cursoId}")
     public Curso obterCurso(@PathVariable Long cursoId) {
         return cursoService.obterCurso(cursoId);
     }
 
     @PutMapping("/cursos/{cursoId}")
     public Curso atualizarCurso(@PathVariable Long cursoId, @RequestBody Curso curso) {
         return cursoService.atualizarCurso(cursoId, curso);
     }
 
     @DeleteMapping("/cursos/{cursoId}")
     public void removerCurso(@PathVariable Long cursoId) {
         cursoService.removerCurso(cursoId);
     }
}
