package actividad2411;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio4CrearFicheroCiudades {

	public static void main(String[] args) {
        // TODO Auto-generated method stub
        String ruta = ".\\src\\ficheros\\";
        String nombreArchivo = "ciudades.txt";
        String ciudades[] = {"Córdoba","Málaga","Córdoba","Cádiz","Almeria","Huelva","Jaen"};

        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter(ruta + nombreArchivo));
            System.out.println("Archivo ciudades.txt creado correctamente.");

            for (String ciudad : ciudades) {
                fw.write(ciudad + "\n");  
            }

            fw.close();  
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Error al crear el archivo productosOrdenadores.txt");
        }
    }

}
