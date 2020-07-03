package com.hibernate.demo.instructor;

import com.hibernate.demo.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReviewMain {

    public static void main(String[] args) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory("Instructor").getCurrentSession()){
            transaction = session.beginTransaction();
            Instructor instructor =
                    new Instructor("Sudhir", "Boothda", "sboothda@gmail.com");
            Course course = new Course("Physics");
            instructor.addCourse(course);
            course.addReview(new Review("Good teacher"));
            course.addReview(new Review("Best teacher"));
            course.addReview(new Review("Not that much good!!!"));
            session.save(course);
            transaction.commit();
        }
        catch (Exception e){
            if(transaction!=null)
                e.printStackTrace();
                transaction.rollback();
        }
    }
}
