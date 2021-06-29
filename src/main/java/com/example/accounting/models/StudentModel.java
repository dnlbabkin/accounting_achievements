package com.example.accounting.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "accounting_achievements")
public class StudentModel implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
    private String name;

    @Column(name="STUDENT_SURNAME", length=50, nullable=false, unique=false)
    private String surname;

    @Column(name="COURSE", length=50, nullable=false, unique=false)
    private int course;

    @Column(name="STUDENT_ACHIEVEMENT", length=250, nullable=false, unique=false)
    private String achievement;

    public StudentModel(String name, String surname, int course, String achievement) {
        this.name = name;
        this.surname = surname;
        this.course = course;
        this.achievement = achievement;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @JsonProperty("course")
    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @JsonProperty("achievement")
    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", course=" + course +
                ", achievement='" + achievement + '\'' +
                '}';
    }
}
