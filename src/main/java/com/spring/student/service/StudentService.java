package com.spring.student.service;

import com.spring.student.model.Student;
import com.spring.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    List<Student> studentList = new ArrayList<>();


    public Student saveStudent(Student student) {
        // studentList.add(student);
        return studentRepository.save(student);
    }

    public List<Student> getAllStudent() {
//        return name == null ? studentList :
//                studentList.stream()
//                        .filter(student -> student.getFirstName().equalsIgnoreCase(name))
//                        .collect(Collectors.toList());
        return studentRepository.findAll();
    }


    public Student getById(String studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        return student.orElseThrow(() -> new RuntimeException(String.format("Student with id : %s  not found", studentId)));
    }

}
