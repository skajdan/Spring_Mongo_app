package com.michal.Spring_Mongo_app;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentRepo studentRepo;


    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();

    }

    @PostMapping
    void createStudent(@RequestBody Student student){
        studentRepo.insert(student);
        System.out.println("Inserting: " + student);
    }

    @PutMapping
    void updateStudent(@PathVariable String id, @RequestBody Student student) {
    if (!studentRepo.existsById(id)){
        System.out.println("Error");

    }
    else{
        studentRepo.findById(id)
                .ifPresent(
                        s -> {
                            s.studentUpdate(student);
                            studentRepo.save(student);

                        }
                );
        System.out.println("Student updated");
    }




    }

}
