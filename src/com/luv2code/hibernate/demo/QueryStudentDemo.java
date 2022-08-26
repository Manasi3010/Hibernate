package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			List<Student> theStudent = session.createQuery("from Student").list();
			theStudent = session.createQuery("from Student s where s.firstName='Manasi'").list();
			theStudent = session.createQuery("from Student s where s.firstName='Manasi' OR s.lastName='Duck'").list();
			DisplayMethod(theStudent);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

	private static void DisplayMethod(List<Student> theStudent) {
		for (Student tempsStudent : theStudent) {
			System.out.println(tempsStudent);
		}
	}

}
