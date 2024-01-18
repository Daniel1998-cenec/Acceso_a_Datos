package Modulo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

public class Main {

	public static void main(String[] args) {
SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		
		ThreadLocalSessionContext context = new ThreadLocalSessionContext ((SessionFactoryImplementor) sessionFactory);
				context.bind(sessionFactory.openSession());
				try {
					Productos Productos=new Productos ("Portatil Omnio", "Portatil 64 Gigas", 1200.0, "HP", 20);
					
					Session session = context.currentSession();
					
					session.beginTransaction();
					
					session.save(Productos);
					
					session.getTransaction().commit();
					
					System.out.println("Productos: "+Productos);
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					ThreadLocalSessionContext.unbind(sessionFactory);
					sessionFactory.close();

				}

	}

}