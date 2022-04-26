package ru.almukanov.dao;


import org.springframework.stereotype.Repository;
import ru.almukanov.entity.Grade;
import ru.almukanov.entity.Rating;
import ru.almukanov.entity.Students;

import java.util.List;
@Repository
public interface StudentDao {
    List<Students> findAll();
    Students findStudentById(Students students);

    void saveStudent(Students student);

    List<Rating> findRating();


    List<Grade> findGrade();
}
