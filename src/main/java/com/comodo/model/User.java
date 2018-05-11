package com.comodo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

/*
    Created by Dmitriy Laletin 
    on 7:56 PM 5/2/2018 May 2018
*/
@Entity
@Table(name = "testUsers")
public class User {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @JsonProperty("id")
    @Column(name = "id")
    private Long Userid;

    @JsonProperty("firstName")
    @Column(name = "firstName")
    private String firstName;

    @JsonProperty("lastName")
    @Column(name = "lastName")
    private String lastName;

    @JsonProperty("birthDate")
    @Column(name = "birthDate")
    private Date birthDate;

    @JsonProperty("gender")
    @Column(name = "gender")
    private String gender;

    public User() {
    }

    public Long getId() {
        return Userid;
    }

    public void setId(Long id) {
        this.Userid = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
