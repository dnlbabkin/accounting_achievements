package com.example.accounting.controllers;

import com.example.accounting.models.StudentModel;
import com.example.accounting.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounting-rest")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping(value = "/student", produces = "application/json")
    public ResponseEntity<StudentModel> getStudent(@RequestBody StudentModel studentModel){
        System.out.println("Name: " + studentModel.getName());
        System.out.println("Surname: " + studentModel.getSurname());
        System.out.println("Course: " + studentModel.getCourse());
        System.out.println("Achievement: " + studentModel.getAchievement());

        studentRepository.save(new StudentModel(studentModel.getName(), studentModel.getSurname(), studentModel.getCourse(), studentModel.getAchievement()));

        return new ResponseEntity<StudentModel>(studentModel, HttpStatus.OK);
    }
}
