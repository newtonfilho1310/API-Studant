package br.edu.imepac.api_student.controllers;

import br.edu.imepac.api_student.entities.Student;
import br.edu.imepac.api_student.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService servicoAluno;

    public StudentController(StudentService servicoAluno) {
        this.servicoAluno = servicoAluno;
    }

    @PostMapping
    public ResponseEntity<Student> cadastrar(@RequestBody Student aluno) {
        Student alunoSalvo = servicoAluno.criar(aluno);
        return ResponseEntity.ok(alunoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Student>> listarTodos() {
        List<Student> listaAlunos = servicoAluno.listarTodos();
        return ResponseEntity.ok(listaAlunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> buscarPorId(@PathVariable Long id) {
        return servicoAluno.buscarPorId(id)
                .map(aluno -> ResponseEntity.ok(aluno))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> atualizar(@PathVariable Long id, @RequestBody Student aluno) {
        Student alunoAtualizado = servicoAluno.atualizar(id, aluno);
        return ResponseEntity.ok(alunoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        servicoAluno.deletar(id);
        return ResponseEntity.noContent().build();
    }
}


