package br.edu.imepac.api_student.services;

import br.edu.imepac.api_student.entities.Student;
import br.edu.imepac.api_student.exceptions.StudentNotFoundException;
import br.edu.imepac.api_student.repositories.StudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    @DisplayName("Should create a student successfully")
    void createStudentSuccess() {
        // Arrange (Preparação)
        Student newStudent = new Student(null, "Newton Filho", "newton@email.com");
        Student savedStudent = new Student(1L, "Newton Filho", "newton@email.com");
        
        when(studentRepository.save(any(Student.class))).thenReturn(savedStudent);

        // Act (Ação)
        Student result = studentService.create(newStudent);

        // Assert (Verificação)
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Newton Filho", result.getNome());
        verify(studentRepository, times(1)).save(newStudent);
    }

    @Test
    @DisplayName("Should find a student by ID successfully")
    void findStudentByIdSuccess() {
        // Arrange
        Student student = new Student(1L, "Newton Filho", "newton@email.com");
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        // Act
        Optional<Student> result = studentService.findById(1L);

        // Assert
        assertTrue(result.isPresent());
        assertEquals("Newton Filho", result.get().getNome());
        verify(studentRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Should throw exception when updating non-existing student")
    void updateStudentNotFoundThrowsException() {
        // Arrange
        Student updateData = new Student(null, "Novo Nome", "novo@email.com");
        when(studentRepository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(StudentNotFoundException.class, () -> studentService.update(99L, updateData));
        verify(studentRepository, never()).save(any(Student.class));
    }
    
    @Test
    @DisplayName("Should delete a student successfully")
    void deleteStudentSuccess() {
        // Arrange
        Student student = new Student(1L, "Newton Filho", "newton@email.com");
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        // Act
        studentService.delete(1L);

        // Assert
        verify(studentRepository, times(1)).findById(1L);
        verify(studentRepository, times(1)).delete(student);
    }
}
