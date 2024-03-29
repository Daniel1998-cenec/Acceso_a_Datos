package tercerEjercicio;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MostrarRegistros {
    public static void mostrarRegistros() {
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            // Consultar todos los registros de la tabla "fabricante"
            session.beginTransaction();
           
            List<Fabricante> fabricantes = session.createQuery("from Fabricante", Fabricante.class).list();

            // Imprimir los resultados
            for (Fabricante fabricante : fabricantes) {
                System.out.println("Codigo: " + fabricante.getId() + ", Nombre: " + fabricante.getNombre());
            }

            // Hacer commit de la transacción
            session.getTransaction().commit();
        } catch (Exception e) {
            // Manejar la excepción de manera adecuada (mostrar mensaje o registrar en un sistema de registro)
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        mostrarRegistros();
    }
}