package ru.almukanov.service;

import ru.almukanov.entity.Grade;
import ru.almukanov.entity.Rating;
import ru.almukanov.entity.Students;

import java.util.List;

public interface StudetnService {
    List<Students> findAll();
    void saveStudent(Students student);

    List<Rating> findRating();

    List<Grade> findGrade();

}
