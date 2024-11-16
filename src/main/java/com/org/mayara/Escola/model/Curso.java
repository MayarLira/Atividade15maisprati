package com.org.mayara.Escola.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    @ManyToMany(mappedBy = "cursos")  // Mapeado pela coluna cursos em "Alunos"
    @Builder.Default
    private Set<Aluno> alunos = new HashSet<>();
}
