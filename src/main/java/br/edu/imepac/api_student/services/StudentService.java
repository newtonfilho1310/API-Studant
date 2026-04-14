package br.edu.imepac.api_student.services;

import br.edu.imepac.api_student.entities.Student;
import br.edu.imepac.api_student.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository repositorioAluno;

    public StudentService(StudentRepository repositorioAluno) {
        this.repositorioAluno = repositorioAluno;
    }

    public Student criar(Student aluno) {
        return repositorioAluno.save(aluno);
    }

    public List<Student> listarTodos() {
        return repositorioAluno.findAll();
    }

    public Optional<Student> buscarPorId(Long id) {
        return repositorioAluno.findById(id);
    }

    public Student atualizar(Long id, Student dadosAluno) {
        Student aluno = repositorioAluno.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno nao encontrado com o id: " + id));

        aluno.setNome(dadosAluno.getNome());
        aluno.setEmail(dadosAluno.getEmail());

        return repositorioAluno.save(aluno);
    }

    public void deletar(Long id) {
        Student aluno = repositorioAluno.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno nao encontrado com o id: " + id));

        repositorioAluno.delete(aluno);
    }
}
