package ru.almukanov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.almukanov.dao.StudentDao;
import ru.almukanov.entity.Grade;
import ru.almukanov.entity.Rating;
import ru.almukanov.entity.Students;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class StudentsServiceImpl implements StudentService {
    private StudentDao studentDao;
    @Autowired
    public StudentsServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    @Transactional
    @Override
    public List<Rating> findAll() {
        return studentDao.findAll();
    }

    @Override
    @Transactional
    public void saveStudent(Students student) {
        studentDao.saveStudent(student);
    }

    @Override
    @Transactional
    public List<Rating> findRating() {
        return studentDao.findRating();
    }

    @Override
    @Transactional
    public List<Grade> findGrade() {
        return studentDao.findGrade();
    }

    @Override
    @Transactional
    public List<Rating> findAllByGrade(Long id) {
        return studentDao.findAllByGrade(id);
    }

    @Override
    @Transactional
    public void saveRating(double rating, int id) {
        double rate = studentDao.findRatingById(id);
        rating += rate;
        studentDao.saveRating(rating, id);
    }

    public double calculatingRate( double answerActivity, double selfActivity, double questionfActivity){

        double rate = (double)(answerActivity+selfActivity*2+questionfActivity*2)/3;
        rate = Double.parseDouble(new DecimalFormat("#0.00").format(rate).replace(",","."));

        return rate;
    }

    @Override
    @Transactional
    public Students findStudentByID(int id) {
        return studentDao.findStudentByID(id);
    }


}
