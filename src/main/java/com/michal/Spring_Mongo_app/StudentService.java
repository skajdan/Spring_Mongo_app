package com.michal.Spring_Mongo_app;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {


    private final StudentRepo studentRepo;


    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
}
