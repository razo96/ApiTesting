package com.example.PostmanTest.Service;

import com.example.PostmanTest.Entity.StudentEntity;
import com.example.PostmanTest.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;

    public List<StudentEntity> findAll() { return studentRepository.findAll();}


    public StudentEntity getById(long id) {
        if (studentRepository.findById(id).isPresent()) {
            return studentRepository.findById(id).get();
        }
        return null;
    }

    public StudentEntity addStudent(StudentEntity student) { return studentRepository.save(student); }

    public void deleteById(long id) {studentRepository.deleteById(id);}


    public void updateById(long id, StudentEntity student) {

        if (studentRepository.findById(id).isPresent()) {
            System.out.println("Hello");
            StudentEntity fromdb = getById(id);
            fromdb.setFirstName(student.getFirstName());
            fromdb.setLastName(student.getLastName());
            fromdb.setEmail(student.getEmail());
            System.out.println(fromdb);
            studentRepository.save(fromdb);
        } else {
            System.out.println("BYEEE");
        }
    }


    public void update(long id, StudentEntity student) {
        if (studentRepository.findById(id).isPresent()) {
            StudentEntity fromdb = getById(id);

            if (student.getFirstName() == null) {fromdb.setFirstName(fromdb.getFirstName());}
            else {fromdb.setFirstName(student.getFirstName());}

            if (student.getLastName() == null) {fromdb.setLastName(fromdb.getLastName());}
            else {fromdb.setLastName(student.getLastName());}

            if (student.getEmail() == null) {fromdb.setEmail(fromdb.getEmail());}
            else {fromdb.setEmail(student.getEmail());}

            studentRepository.save(fromdb);
        }
    }
}













