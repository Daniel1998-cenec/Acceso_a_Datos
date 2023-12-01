package actividad2411;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio2CrearFicheroMalagaContexto {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String ruta = ".\\src\\ficheros\\";
        String nombreArchivo = "malaga.txt";
        String contenido = "Málaga es lo mejor del mundo";

        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter(ruta + nombreArchivo));
            System.out.println("Archivo malaga.txt creado correctamente.");
            fw.write(contenido);
            fw.close();  // Es buena práctica cerrar el BufferedWriter después de usarlo
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Error al crear el archivo malaga.txt");
        }
    }
}
