package com.hibernate.demo.instructor;

import com.hibernate.demo.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class InstructorCourseMain {
    public static void main(String[] args) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory("Instructor").getCurrentSession()) {
            transaction = session.beginTransaction();
            Instructor instructor =
                    new Instructor("Sudhir", "Boothda", "sboothda@gmail.com");

            Course course = new Course("Maths");
            instructor.addCourse(course);
            session.save(course);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
    }
}