package ru.almukanov.service;

import ru.almukanov.entity.Grade;
import ru.almukanov.entity.Rating;
import ru.almukanov.entity.Students;

import java.util.List;

public interface StudentService {
    List<Rating> findAll();
    void saveStudent(Students student);

    List<Rating> findRating();

    List<Grade> findGrade();

    List<Rating> findAllByGrade(Long id);

    void saveRating(double rating, int id);
    public double calculatingRate( double answerActivity, double selfActivity, double questionfActivity);


    Students findStudentByID(int id);
}
