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
SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		
		ThreadLocalSessionContext context = new ThreadLocalSessionContext ((SessionFactoryImplementor) sessionFactory);
				context.bind(sessionFactory.openSession());
				try {
					Profesores profesor=new Profesores ("Alberto", "Ruiz", "calle avila 3", "29718", "Granada", "Andalucia", "654987000");
					
					Session session = context.currentSession();
					
					session.beginTransaction();
					
					session.save(profesor);
					
					session.getTransaction().commit();
					
					System.out.println("Profesor: "+profesor);
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					ThreadLocalSessionContext.unbind(sessionFactory);
					sessionFactory.close();

				}
	}

}
