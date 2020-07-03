package com.hibernate.demo.student;

import com.hibernate.demo.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;

public class UpdateStudent {

    public static void main(String[] args) {

        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory("Student").getCurrentSession()){
            transaction = session.beginTransaction();
            //Student student = session.get(Student.class,1);
            //student.setFirstName("Jacky");
            Query query = session.createQuery("update Student s set s.firstName =:firstName where s.id =:id");
            query.setParameter("firstName","Jacky");
            query.setParameter("id",1);
            query.executeUpdate();
            transaction.commit();
        }catch (Exception e){
            //if(transaction!=null)
                //transaction.rollback();
            e.printStackTrace();
        }
    }
}
