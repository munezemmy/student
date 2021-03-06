package com.spring.student.controller;

import com.spring.student.exceptionHanling.RestResponse;
import com.spring.student.model.Student;
import com.spring.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/rest")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {


        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.OK);
    }


    @GetMapping("/student")
    public ResponseEntity<RestResponse<List<Student>>> getStudents(@RequestParam(name = "studentId", required = false) String studentId) {
        RestResponse<List<Student>> restResponse = new RestResponse<>();
        restResponse.setData(studentId != null ?
                Collections.singletonList(studentService.getById(studentId)) : studentService.getAllStudent());

        return new ResponseEntity(restResponse, HttpStatus.OK);
    }


}
