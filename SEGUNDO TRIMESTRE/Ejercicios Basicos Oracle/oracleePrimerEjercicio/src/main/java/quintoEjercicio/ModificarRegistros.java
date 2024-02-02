package quintoEjercicio;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ModificarRegistros {
    public static void modificarRegistros() {
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            // Consultar todos los registros de la tabla "Categorias"
            session.beginTransaction();
            String updateHql = "UPDATE Producto SET Nombre = 'Router', Descripcion= 'Basura', Precio= '100,99', unidades = 500  WHERE id = 15";
            Query<?> updateQuery = session.createQuery(updateHql);
            updateQuery.executeUpdate();
           session.getTransaction().commit();
           
        } catch (Exception e) {
            // Manejar la excepción de manera adecuada (mostrar mensaje o registrar en un sistema de registro)
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
    	modificarRegistros();
    }
}