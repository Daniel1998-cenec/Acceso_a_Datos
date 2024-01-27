package cuartoEjercicio;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MostrarRegistros {
    public static void mostrarRegistros() {
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            // Consultar todos los registros de la tabla "empresa"
            session.beginTransaction();
           
            List<Alumno> alumnos = session.createQuery("from Alumno", Alumno.class).list();

            // Imprimir los resultados
            for (Alumno alumno : alumnos) {
                System.out.println("ID: " + alumno.getId() + ", Nombre: " + alumno.getNombre() + ", Apellido 1: " + alumno.getApellido1()
                + ", Apellido 2: " + alumno.getApellido2()+ ", Es repetidor: " + alumno.getEs_repetidor()+ ", Teléfono: " + alumno.getTelefono());
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
