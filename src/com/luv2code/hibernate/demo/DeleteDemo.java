package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hb.one.to.one.uni.Instructor;
import hb.one.to.one.uni.InstructorDetails;

public class DeleteDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the object

			// start a transaction
			session.beginTransaction();

			int theId = 7;
			InstructorDetails tempInstructor = session.get(InstructorDetails.class, theId);
			System.out.println("Found instructor" + tempInstructor);

			// delete the instructor object
			if (tempInstructor != null) {
				System.out.println("Deleting the instructor" + tempInstructor);
				session.delete(tempInstructor);
			}
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
