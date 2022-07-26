package com.michal.Spring_Mongo_app;

import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;

import java.util.List;


@Data
@Document
public class Student {
    @Id
    private String  id;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String phoneNumber;
    private Gender gender;
    private Address address;
    private List<String> favSub;
    private LocalDateTime crated;

    public Student(final String firstName, final String lastName, final String phoneNumber, final Gender gender, final Address address, final List<String> favSub, final LocalDateTime crated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.address = address;
        this.favSub = favSub;
        this.crated = crated;
    }

    public void studentUpdate(final Student newStudent){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.address = address;
        this.favSub = favSub;
        this.crated = crated;

    }




}
