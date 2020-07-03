package com.hibernate.demo;

import com.hibernate.demo.instructor.Course;
import com.hibernate.demo.instructor.Instructor;
import com.hibernate.demo.instructor.InstructorDetail;
import com.hibernate.demo.instructor.Review;
import com.hibernate.demo.student.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil  {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(String className) {

        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hiber_student?useSSL=false");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "root");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "update");

                configuration.setProperties(settings);

                if(className.equals("Student"))
                    configuration.addAnnotatedClass(Student.class);
                else
                    configuration.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
                            .addAnnotatedClass(Course.class)
                            .addAnnotatedClass(Review.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
