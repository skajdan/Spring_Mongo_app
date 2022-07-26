package com.michal.Spring_Mongo_app;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepo extends MongoRepository<Student,String> {

    Optional<Student> findStudentByPhoneNumber(String phoneNumber);


}
