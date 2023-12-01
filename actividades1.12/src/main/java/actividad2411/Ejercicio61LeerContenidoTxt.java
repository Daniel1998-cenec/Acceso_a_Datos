package actividad2411;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio61LeerContenidoTxt {

    public static void main(String[] args) {
        String[] archivos = {"ciudades.txt", "productosOrdenadores.txt", "malaga.txt", "sevilla.txt", "granada.txt"};
        for (String archivo : archivos) {
            System.out.println(archivo + ":");
            leerFicheros(archivo);
            System.out.println();
        }
    }

    public static void leerFicheros(String nombreArchivo) {
        try {
            File archivo = new File(".\\src\\ficheros\\" + nombreArchivo);
            if (!archivo.exists()) {
                System.out.println("El archivo " + nombreArchivo + " no existe");
                return;
            }
            
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
