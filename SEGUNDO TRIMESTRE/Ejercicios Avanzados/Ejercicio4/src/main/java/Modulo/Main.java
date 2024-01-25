package Modulo;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

import Modulo.Fabricante;
import Modulo.Productos;
import Modulo.Compra;

public class Main {

	public static void main(String[] args) {
		//Configurar la sesion de Hibernate
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		
		ThreadLocalSessionContext context = new ThreadLocalSessionContext ((SessionFactoryImplementor) sessionFactory);
				context.bind(sessionFactory.openSession());
				try {
					//FABRICANTE****************************************************
		            // Crear objeto fabricante
		           	Fabricante fabricante = new Fabricante("pc gaming4");

		        	// Obtener la sesión actual
		        	Session session = context.currentSession();

		        	// Iniciar transacción
		        	session.beginTransaction();

		        	// Guardar objeto fabricante en la base de datos
		        	session.save(fabricante);      	     	

		        	// Hacer commit de la transacción
		        	session.getTransaction().commit();
		        	
		        	//PRODUCTOS**********************************
		        	// Crear objeto producto
		        
		        	Productos producto = new Productos("PORTATIL gaming4", 3000.00, fabricante);

		        	// Obtener la sesión actual
		        	Session session1 = context.currentSession();

		        	// Iniciar transacción
		        	session1.beginTransaction();

		        	// Guardar objeto producto en la base de datos
		        	session1.save(producto);

		        	// Hacer commit de la transacción
		        	session1.getTransaction().commit();	
		        	
		        	// Crear objeto compras
		           	Compra compra = new Compra(Date.valueOf("2024-01-03"),1,producto);

		        	// Obtener la sesión actual
		        	Session session2 = context.currentSession();

		        	// Iniciar transacción
		        	session2.beginTransaction();

		        	// Guardar objeto fabricante en la base de datos
		        	session2.save(compra);      	     	

		        	// Hacer commit de la transacción
		        	session2.getTransaction().commit();
		        	System.out.println(compra.toString());
		        	
		        	System.out.println(producto.toString());
		        	System.out.println(fabricante.toString());
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					ThreadLocalSessionContext.unbind(sessionFactory);
					sessionFactory.close();

				}
				
	}

}
