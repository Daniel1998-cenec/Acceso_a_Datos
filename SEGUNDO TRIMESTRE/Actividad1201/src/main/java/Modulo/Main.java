package Modulo;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		
		ThreadLocalSessionContext context = new ThreadLocalSessionContext ((SessionFactoryImplementor) sessionFactory);
				context.bind(sessionFactory.openSession());
				try {
					Alumno alumno=new Alumno ("Alberto", "Ruiz", "Rodrigez", Date.valueOf("1975-05-05"), "No", 33333);
					
					Session session = context.currentSession();
					
					session.beginTransaction();
					
					session.save(alumno);
					
					session.getTransaction().commit();
					
					System.out.println("Alumno: "+alumno);
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					ThreadLocalSessionContext.unbind(sessionFactory);
					sessionFactory.close();

				}
	}

}
