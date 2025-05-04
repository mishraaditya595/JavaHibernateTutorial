package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Student student = new Student();
//        student.setName("Harsh");
//        student.setSid(3);
//        student.setMarks(22);
//        addNewStudentData(student);
//        fetchStudentDataByRollNumber(7);
//        updateStudentData(student);
//        deleteStudentData(8);
//        fetchAlienDataByRollNumber(7);

//        Laptop laptop = new Laptop();
//        laptop.setBrand("Asus");
//        laptop.setModel("ROG");
//        laptop.setRam(16);
//
//        Alien alien = new Alien();
//        alien.setId(1);
//        alien.setName("Raju");
//        alien.setTech("Java");
//        alien.setLaptop(laptop);
//        addNewAlienData(alien);
        fetchAlienDataByRollNumber(1);
    }

    private static void deleteStudentData(int rollNum) {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Student studentToDelete = session.get(Student.class, rollNum);
        Transaction transaction = session.beginTransaction();
        session.remove(studentToDelete); //checks if the data is already present, if yes, it updates else it inserts
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    private static void updateStudentData(Student student) {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        session.merge(student); //checks if the data is already present, if yes, it updates else it inserts
        transaction.commit();

        System.out.println(student);
        session.close();
        sessionFactory.close();
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

    static void fetchAlienDataByRollNumber(int rollNumber) {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Alien.class)
                .configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Alien alien = session.get(Alien.class, rollNumber);
        System.out.println(alien);
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

    static void addNewAlienData(Alien alien) {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Alien.class)
                .configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(alien);
        transaction.commit();

        System.out.println(alien);

        session.close();
        sessionFactory.close();
    }
}