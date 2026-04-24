package br.edu.imepac.api_student.controllers;

import br.edu.imepac.api_student.entities.Student;
import br.edu.imepac.api_student.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

 
    @PostMapping
    public ResponseEntity<Student> cadastrar(@RequestBody Student student) {
        Student studentSaved = studentService.create(student);
        return ResponseEntity.ok(studentSaved);
    }

   
    @GetMapping
    public ResponseEntity<List<Student>> listarTodos() {
        List<Student> students = studentService.findAll();
        return ResponseEntity.ok(students);
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<Student> buscarPorId(@PathVariable Long id) {
        return studentService.findById(id)
                .map(student -> ResponseEntity.ok(student))
                .orElse(ResponseEntity.notFound().build());
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Student> atualizar(@PathVariable Long id, @RequestBody Student student) {
        Student studentUpdated = studentService.update(id, student);
        return ResponseEntity.ok(studentUpdated);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

