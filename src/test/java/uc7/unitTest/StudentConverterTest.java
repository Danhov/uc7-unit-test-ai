package uc7.unitTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentConverterTest {

    private StudentConverter studentConverter;

    @BeforeEach
    void setUp() {
        studentConverter = new StudentConverter();
    }

    // Positive Test Cases

    @Test
    void testConvertStudentsHighAchiever() {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setName("John");
        student.setAge(25);
        student.setGrade(92);
        students.add(student);

        List<Student> convertedStudents = studentConverter.convertStudents(students);

        assertTrue(convertedStudents.get(0).isHonorRoll());
    }

    @Test
    void testConvertStudentsExceptionalYoungHighAchiever() {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setName("Alice");
        student.setAge(20);
        student.setGrade(95);
        students.add(student);

        List<Student> convertedStudents = studentConverter.convertStudents(students);

        assertTrue(convertedStudents.get(0).isExceptional());
    }

    @Test
    void testConvertStudentsPassed() {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setName("Bob");
        student.setAge(22);
        student.setGrade(75);
        students.add(student);

        List<Student> convertedStudents = studentConverter.convertStudents(students);

        assertTrue(convertedStudents.get(0).isPassed());
    }

    @Test
    void testConvertStudentsFailed() {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setName("Charlie");
        student.setAge(18);
        student.setGrade(65);
        students.add(student);

        List<Student> convertedStudents = studentConverter.convertStudents(students);

        assertFalse(convertedStudents.get(0).isPassed());
    }

    // Negative Test Cases

    @Test
    void testConvertStudentsEmptyArray() {
        List<Student> students = new ArrayList<>();

        List<Student> convertedStudents = studentConverter.convertStudents(students);

        assertTrue(convertedStudents.isEmpty());
    }

    @Test
    void testConvertStudentsNullInput() {
        assertThrows(NullPointerException.class, () -> studentConverter.convertStudents(null));
    }
}