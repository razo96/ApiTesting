package com.example.PostmanTest.Controller;


import com.example.PostmanTest.Entity.StudentEntity;
import com.example.PostmanTest.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/getAllStudents")
    public List<StudentEntity> getAll() {
        return studentService.findAll();
    }

    @GetMapping("/getStudentById/{id}")
    public StudentEntity getById(@PathVariable long id) {
        return studentService.getById(id);
    }

    @PostMapping("/register")
    public StudentEntity register(@RequestBody StudentEntity student) {
        return studentService.addStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id) { studentService.deleteById(id);}

    @PutMapping("/updateStudent/{id}")
    public void updateById(@RequestBody StudentEntity student, @PathVariable long id) { studentService.updateById(id, student); }

    @PutMapping("/update/{id}")
    public void update(@RequestBody StudentEntity student, @PathVariable long id) { studentService.update(id, student); }

}












