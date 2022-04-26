package ru.almukanov.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.almukanov.entity.Grade;
import ru.almukanov.entity.Rating;
import ru.almukanov.entity.Students;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{
    private SessionFactory sessionFactory;
    @Autowired
    public StudentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    public List<Students> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Students> query = session.createQuery("FROM Students", Students.class);

      // return GradeDao.HibernateUtil.getSessionFactory().openSession().createQuery("FROM  Students s WHERE s.grade.gradeNumber  = "+"'"+gr+"'").list();
        List<Students> students = query.getResultList();
        return students;

    }

@Transactional
    public Students findStudentById(Students students) {
        Session session  = sessionFactory.getCurrentSession();
        Query<Students> query = session.createQuery("FROM  Students WHERE id="+students.getId(),Students.class);
        Students studentsById = query.getSingleResult();
        //return GradeDao.HibernateUtil.getSessionFactory().openSession().get(Students.class, id);
        return studentsById;
    }

    @Override
    public void saveStudent(Students student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }

    @Override
    public List<Rating> findRating() {
        Session session = sessionFactory.getCurrentSession();
        Query<Rating> query = session.createQuery("FROM Rating", Rating.class);
        List<Rating> rating = query.getResultList();
        return rating;
    }

    @Override
    public List<Grade> findGrade() {
        Session session = sessionFactory.getCurrentSession();
        Query<Grade> query = session.createQuery("FROM Grade", Grade.class);
        List<Grade> grades = query.getResultList();
        return grades;
    }


}