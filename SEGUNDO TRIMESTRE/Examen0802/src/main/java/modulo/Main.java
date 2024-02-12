package modulo;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

public class Main {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
		ThreadLocalSessionContext.bind(sessionFactory.openSession());
		try {
			Paciente paciente = new Paciente("Daniel", "Vargas Holguin", "Malaga", "Calle cerezo 06", 627900876, 33,
					"El paciente present graves problemas de pulmonía");

			Session session = context.currentSession();

			session.beginTransaction();

			session.save(paciente);

			session.getTransaction().commit();

			// -----------------------------------------------------

			Medico medico = new Medico("Jose Roberto", "Lopez", "Cirujano");

			Session session2 = context.currentSession();

			session2.beginTransaction();

			session2.save(medico);

			session2.getTransaction().commit();

			// ------------------------------------------------------
			Cita cita = new Cita(Date.valueOf("2024-01-03"),"10:30", paciente, medico);

			Session session3 = context.currentSession();

			session3.beginTransaction();

			session3.save(cita);

			session3.getTransaction().commit();
			// -----------------------------------------------------

			// ----------------------------------------------------------

			// ----------------------------------------------------------

			System.out.println("Paciente: " + paciente);
			System.out.println("Medico: " + medico);
			System.out.println("Cita: " + cita);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ThreadLocalSessionContext.unbind(sessionFactory);
			sessionFactory.close();

		}

	}

}