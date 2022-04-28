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



    public List<Rating> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Rating> query = session.createQuery("FROM Rating", Rating.class);

      // return GradeDao.HibernateUtil.getSessionFactory().openSession().createQuery("FROM  Students s WHERE s.grade.gradeNumber  = "+"'"+gr+"'").list();
        List<Rating> students = query.getResultList();
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
    public void saveStudent(Students st) {
        Session session = sessionFactory.getCurrentSession();
        session.save(st);
        Query query = session.createSQLQuery("INSERT INTO rating (student,rating) VALUES ("+st.getId()+",0)");
        query.executeUpdate();
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

    @Override
    public List<Rating> findAllByGrade(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Rating> query = session.createQuery("FROM Rating as r  WHERE r.student.grade.id = :id");
        query.setParameter("id", id);
        List<Rating> ratings = query.getResultList();
        return ratings;
    }

    @Override
    public void saveRating(double rating, int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("UPDATE rating SET rating= "+rating+" where student="+id);
        query.executeUpdate();
    }

    @Override
    public Students findStudentByID(int id) {
        Session session = sessionFactory.getCurrentSession();
        Students student = session.get(Students.class, id);
        return student;
    }


}
