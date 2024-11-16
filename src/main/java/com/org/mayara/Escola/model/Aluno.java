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
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    @ManyToMany
    @JoinTable(
        name = "curso_aluno", // Join table name
        joinColumns = @JoinColumn(name = "aluno_id"), // Foreign key in join table for Aluno
        inverseJoinColumns = @JoinColumn(name = "curso_id") // Foreign key in join table for Curso
    )
    @Builder.Default
    private Set<Curso> cursos = new HashSet<>(); // Default value to avoid null references
}
