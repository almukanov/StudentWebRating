package ru.almukanov.entity;


import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "grade", schema="public")
@Component
public class Grade {

//fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "grade_number", nullable = false)
    private String gradeNumber;
//--end--fields
    public Grade() {
    }

    public Grade(String gradeNumber) {
        this.gradeNumber = gradeNumber;

    }

    public String getGradeNumber() {
        return gradeNumber;
    }

    public void setGradeNumber(String gradeNumber) {
        this.gradeNumber = gradeNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

