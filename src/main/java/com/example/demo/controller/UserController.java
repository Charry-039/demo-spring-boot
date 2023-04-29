package com.example.demo.controller;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Student;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private StudentMapper studentMapper;
    private final Gson gson = new Gson();

    @GetMapping("/students")
    public String getStudents() {
        List<Student> students = studentMapper.selectList(null);
        return gson.toJson(students);
    }

    @PostMapping("/add")
    public void addStudent(@RequestBody Student student) {
        studentMapper.insert(student);
    }

    @PostMapping("/delete")
    public void removeStudent(@RequestBody Student student) {
        studentMapper.deleteById(student);
    }

    @PostMapping("/update")
    public void updateStudent(@RequestBody Student student){
        studentMapper.updateById(student);
    }
}
