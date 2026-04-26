package br.edu.imepac.api_student.exceptions;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(Long id) {
        super("Estudante não encontrado com o ID: " + id);
    }

    public StudentNotFoundException(String message) {
        super(message);
    }
}
