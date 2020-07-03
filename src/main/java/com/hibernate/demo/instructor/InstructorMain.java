package com.hibernate.demo.instructor;

import com.hibernate.demo.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class InstructorMain {

    public static void main(String[] args) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory("Instructor").getCurrentSession()){

            transaction = session.beginTransaction();
            Instructor instructor =
                    new Instructor("Sudhir","Boothda","sboothda@gmail.com");
            InstructorDetail instructorDetail =
                    new InstructorDetail("https://youtube.com/sboothda","Playing Cricket");
            instructor.setInstructorDetail(instructorDetail);
            session.save(instructor);
            transaction.commit();
        }
        catch (Exception e){
            if(transaction!=null)
                transaction.rollback();
            e.printStackTrace();
        }
    }
}
