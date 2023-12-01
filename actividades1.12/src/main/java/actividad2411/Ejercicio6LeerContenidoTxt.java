package actividad2411;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio6LeerContenidoTxt {

    public static void main(String[] args) {
        String ruta = ".\\src\\ficheros\\";
        String txt[] = {"ciudades.txt", "malaga.txt", "productosOrdenadores.txt"};

        List<String> contenidoArrayList = new ArrayList<>();

        try {
            for (String archivo : txt) {
                FileReader fr = new FileReader(ruta + archivo);
                BufferedReader br = new BufferedReader(fr);

                String linea;
                StringBuilder contenido = new StringBuilder();
                while ((linea = br.readLine()) != null) {
                    contenido.append(linea).append("\n");
                }

                contenidoArrayList.add(contenido.toString());

                br.close();
                fr.close();
            }

            // Ahora contenidoArrayList contiene el contenido de cada archivo en un elemento separado
            for (String contenido : contenidoArrayList) {
                System.out.println(contenido);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
