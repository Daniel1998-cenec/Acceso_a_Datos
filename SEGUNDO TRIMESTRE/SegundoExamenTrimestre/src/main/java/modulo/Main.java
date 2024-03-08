package modulo;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
		context.bind(sessionFactory.openSession());
		try {
			Asignaturas asignaturas = new Asignaturas("Desarrollo de Aplicaciones Multiplataforma", "DAM01", "Informática", 200, "Esta asignatura cubre los fundamentos del desarrollo de aplicaciones para múltiples plataformas, incluyendo programación en diversos lenguajes y el uso de frameworks y herramientas de desarrollo");

			Session session = context.currentSession();

			session.beginTransaction();

			session.save(asignaturas);

			session.getTransaction().commit();

			System.out.println("Asignatura: " + asignaturas);
			
			Asignaturas asignaturas2 = new Asignaturas("Administración de Sistemas Informáticos en Red", "ASIR01", "Informática", 180, "Esta asignatura se enfoca en la administración y configuración de sistemas informáticos en red, abarcando desde la instalación y mantenimiento de servidores hasta la gestión de servicios y seguridad de redes");

			Session session2 = context.currentSession();

			session2.beginTransaction();

			session2.save(asignaturas2);

			session2.getTransaction().commit();

			System.out.println("Asignatura: " + asignaturas2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ThreadLocalSessionContext.unbind(sessionFactory);
			sessionFactory.close();

		}
	}

}
