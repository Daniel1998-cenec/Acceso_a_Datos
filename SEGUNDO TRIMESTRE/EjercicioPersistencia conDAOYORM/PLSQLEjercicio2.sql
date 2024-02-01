Create type empleado2 as object (
id_empleado number(4),
nombre Varchar2(30),
apellido varchar2(40),
map member function get_id_empleado return number
);
/
CREATE TYPE BODY empleado2 AS
  MAP MEMBER FUNCTION get_id_empleado RETURN NUMBER IS
  BEGIN
    RETURN id_empleado;
  END;
END;
/
CREATE OR REPLACE PROCEDURE ejecutar_bloque_plsql(p_output OUT VARCHAR2) AS
  emp empleado2;
BEGIN
  -- Inicializar la variable empleado
  emp := empleado2 (2, 'Max', 'Little');


  -- Acceder a los atributos del objeto
  p_output := 'ID Empleado: ' || emp.id_empleado || CHR(10) ||
              'Nombre: ' || emp.nombre || CHR(10) ||
              'Apellido: ' || emp.apellido || CHR(10) ||
              'ID Empleado desde la función: ' || emp.get_id_empleado();
END;
/

