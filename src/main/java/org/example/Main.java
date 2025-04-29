package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        fetchStudentDataByRollNumber(7);
    }

    static void fetchStudentDataByRollNumber(int rollNumber) {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Student student = session.get(Student.class, rollNumber);
        System.out.println(student);
        session.close();
        sessionFactory.close();
    }

    static void addNewStudentData(Student student) {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(student);
        transaction.commit();

        System.out.println(student);

        session.close();
        sessionFactory.close();
    }
}