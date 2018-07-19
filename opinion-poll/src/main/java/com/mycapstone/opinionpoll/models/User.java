package com.mycapstone.opinionpoll.models;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Service
@Repository
public class User {

    @Id
    @GeneratedValue
    private int id;



    @NotNull
    private String pwHash;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @NotNull
    private String email;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private Set<Query> queries = new HashSet<>();



    public User() {}

    public User(String password, String email, String firstName, String lastName) {

        this.pwHash = hashPassword(password);
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public User(String email, String firstName, String lastName) {

        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Set<Query> getQueries() {
        return queries;
    }

    public void setQueries(Set<Query> queries) {
        this.queries = queries;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) {  this.firstName = firstName;  }

    public String getLastName() { return lastName;}

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email;}

    public void setEmail(String email) { this.email = email;}

    private static String hashPassword(String password) {
        return encoder.encode(password);
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }
    @Override
    public String toString() {
        return "User{" + "id=" + id + ",firstname='" + firstName  + '\'' + ",lastname='" + lastName + '\'' +
                 '}';
    }



}