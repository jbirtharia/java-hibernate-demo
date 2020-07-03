package com.hibernate.demo.instructor;

import com.hibernate.demo.HibernateUtil;
import org.hibernate.Session;

public class InstructorBidirectionalRelation {

    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSessionFactory("Instructor").getCurrentSession()) {
            session.beginTransaction();
            //Getting details of Instructor using InstructorDetail
            //Fetching Parent object from Child object
            InstructorDetail detail = session.get(InstructorDetail.class,1);
            System.out.println("Instructor : "+detail.getInstructor());
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
