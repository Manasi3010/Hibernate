package hb.one.to.one.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

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

			Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@gmail.com");

			InstructorDetails tempInstructorDetails = new InstructorDetails("http://youtube.com", "love to code");

			tempInstructor.setInstrcutorDetails(tempInstructorDetails);

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving Instructor:  " + tempInstructor);
			session.save(tempInstructor);
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
