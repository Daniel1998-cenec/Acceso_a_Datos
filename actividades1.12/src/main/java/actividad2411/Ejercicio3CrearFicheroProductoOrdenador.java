package actividad2411;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio3CrearFicheroProductoOrdenador {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String ruta = ".\\src\\ficheros\\";
        String nombreArchivo = "productosOrdenadores.txt";
        String contenido[] = {"Portatil", "Monitor", "Moviles", "Altavoces"};

        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter(ruta + nombreArchivo));
            System.out.println("Archivo productosOrdenadores.txt creado correctamente.");

            for (String content : contenido) {
                fw.write(content + "\n");  
            }

            fw.close();  // Es buena práctica cerrar el BufferedWriter después de usarlo
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Error al crear el archivo productosOrdenadores.txt");
        }
    }
}
