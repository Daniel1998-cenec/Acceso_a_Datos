package paciente;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;

import modulo.Paciente;

import java.util.List;

public class ModificarDatos {

    public static void main(String[] args) {

        // Configurar la sesión de Hibernate
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

        // Configurar la sesión en el contexto actual
        ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
        context.bind(sessionFactory.openSession());

        try {
            // Obtener la sesión actual
            Session session = context.currentSession();

            // Iniciar transacción
            session.beginTransaction();

            // Modificar el nombre por "Jose David"
            String updateHql = "UPDATE Paciente SET Nombre = 'Daxter', Apellidos = 'Lopez Vega', Ciudad = 'Madrid', Direccion =  'calle girasol 6',"
            		+ " Telefono = '664345332', Edad = '8', Historial = 'Asmático'  WHERE id = 2";
            Query<?> updateQuery = session.createQuery(updateHql);
            updateQuery.executeUpdate();

            // Realizar una nueva consulta para obtener los datos actualizados
            String selectHql = "FROM Paciente WHERE id = 2";
            Query<Paciente> selectQuery = session.createQuery(selectHql, Paciente.class);
            List<Paciente> paciente = selectQuery.list();

            // Imprimir resultados
            System.out.println("Registros en la tabla paciente después de la actualización:");
            for (Paciente f : paciente) {
                System.out.println(f.toString());
            }

            // Hacer commit de la transacción
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            context.unbind(sessionFactory);
            sessionFactory.close();
        }
    }
}
