package cita;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;

import modulo.Cita;
import modulo.Medico;

import java.sql.Date;
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
            String updateHql = "UPDATE Cita SET Fecha = ('2020-02-03'), Hora = '12:30' WHERE id = 2";
            Query<?> updateQuery = session.createQuery(updateHql);
            updateQuery.executeUpdate();

            // Realizar una nueva consulta para obtener los datos actualizados
            String selectHql = "FROM Cita WHERE id = 2";
            Query<Cita> selectQuery = session.createQuery(selectHql, Cita.class);
            List<Cita> cita = selectQuery.list();

            // Imprimir resultados
            System.out.println("Registros en la tabla cita después de la actualización:");
            for (Cita f : cita) {
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
