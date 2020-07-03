package com.hibernate.demo.student;

import com.hibernate.demo.HibernateUtil;
import com.hibernate.demo.student.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentMain {

    public static void main(String[] args) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory("Student").getCurrentSession()) {

            Student firstStudent = new Student("Jayendra", "Birtharia", "jbirtharia@gmail.com");
            Student secondStudent = new Student("Sachin","Tendulkar","stendulkar@gmail.com");

            Student thirdStudent = new Student("MS","Dhoni","msdhoni@gmail.com");

            // start a transaction
            transaction = session.beginTransaction();
            //Saving object into database
            session.save(firstStudent);
            session.save(secondStudent);
            session.save(thirdStudent);
            //committing transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
