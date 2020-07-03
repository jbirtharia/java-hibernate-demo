package com.hibernate.demo.student;

import com.hibernate.demo.HibernateUtil;
import com.hibernate.demo.student.Student;
import org.hibernate.Session;

import java.util.List;

public class HQLDemoStudent {

    public static void main(String[] args) {

        try(Session session = HibernateUtil.getSessionFactory("Student").getCurrentSession()){
            session.beginTransaction();
            List<Student> students = session.createQuery("from Student").getResultList();
            students.forEach(System.out::println);

            Student student = (Student) session.createQuery("from Student s where s.firstName='Sachin'").getSingleResult();
            System.out.println(student);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
