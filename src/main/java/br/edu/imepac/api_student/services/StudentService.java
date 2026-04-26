package br.edu.imepac.api_student.services;

import br.edu.imepac.api_student.entities.Student;
import br.edu.imepac.api_student.exceptions.StudentNotFoundException;
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

    public Student create(Student aluno) {
        return repositorioAluno.save(aluno);
    }

    public List<Student> findAll() {
        return repositorioAluno.findAll();
    }

    public Optional<Student> findById(Long id) {
        return repositorioAluno.findById(id);
    }

    public Student update(Long id, Student dadosAluno) {
        Student aluno = repositorioAluno.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        aluno.setNome(dadosAluno.getNome());
        aluno.setEmail(dadosAluno.getEmail());

        return repositorioAluno.save(aluno);
    }

    public void delete(Long id) {
        Student aluno = repositorioAluno.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        repositorioAluno.delete(aluno);
    }
}
