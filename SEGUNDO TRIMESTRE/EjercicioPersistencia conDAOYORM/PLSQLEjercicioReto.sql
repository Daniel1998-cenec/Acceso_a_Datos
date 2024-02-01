CREATE TYPE profesor2 AS OBJECT (
  id_profesor NUMBER(4),
  nombre VARCHAR2(30),
  apellido VARCHAR2(40),
  curso VARCHAR2(50),
  MAP MEMBER FUNCTION get_id_profesor RETURN NUMBER
);
/

CREATE TYPE BODY profesor2 AS
  MAP MEMBER FUNCTION get_id_profesor RETURN NUMBER IS
  BEGIN
    RETURN id_profesor;
  END;
END;
/

CREATE OR REPLACE PROCEDURE ejecutar_bloque_plsql(p_output OUT VARCHAR2) AS
  prof profesor2;
BEGIN
  -- Inicializar la variable profesor
  prof := profesor2(2, 'John', 'Doe', 'Math');

  -- Acceder a los atributos del objeto
  p_output := 'ID Profesor: ' || prof.id_profesor || CHR(10) ||
              'Nombre: ' || prof.nombre || CHR(10) ||
              'Apellido: ' || prof.apellido || CHR(10) ||
              'Curso: ' || prof.curso || CHR(10) ||
              'ID Profesor desde la función: ' || prof.get_id_profesor();
END;
/
