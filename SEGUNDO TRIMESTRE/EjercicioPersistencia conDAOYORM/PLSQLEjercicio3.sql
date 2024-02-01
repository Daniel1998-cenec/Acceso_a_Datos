CREATE TYPE alumno2 AS OBJECT (
  id_alumno NUMBER(4),
  nombre VARCHAR2(30),
  apellido VARCHAR2(40),
  MAP MEMBER FUNCTION get_id_alumno RETURN NUMBER
);
/

CREATE TYPE BODY alumno2 AS
  MAP MEMBER FUNCTION get_id_alumno RETURN NUMBER IS
  BEGIN
    RETURN id_alumno;
  END;
END;
/

CREATE OR REPLACE PROCEDURE ejecutar_bloque_plsql(p_output OUT VARCHAR2) AS
  alm alumno2;
BEGIN
  -- Inicializar la variable alumno
  alm := alumno2(2, 'Gaspar', 'Rabadan');

  -- Acceder a los atributos del objeto
  p_output := 'ID Alumno: ' || alm.id_alumno || CHR(10) ||
              'Nombre: ' || alm.nombre || CHR(10) ||
              'Apellido: ' || alm.apellido || CHR(10) ||
              'ID Alumno desde la función: ' || alm.get_id_alumno();
END;
/

