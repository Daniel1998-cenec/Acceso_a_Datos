package examen.Repaso;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcion;
		String ruta = "c:"+File.separator;
		String directorio="hola";
		String nombreFichero = File.separator+"simulacro.txt";
		String txt[] = { "Hola buenas noches, soy tu padre" };
		String rutaFichero = ruta + directorio + nombreFichero;
		boolean salir = false;

		do {

			System.out.println(
					"Selecciona una opción:" + "\n\t 0 - Salir" + "\n\t 1 - Crear Carpeta" + "\n\t 2 - Crear Fichero"
							+ "\n\t 3 - Eliminar Carpeta" + "\n\t 4 - Eliminar fichero" + "\n\t 5 - Leer Fichero");

			opcion = Byte.parseByte(sc.nextLine());

			switch (opcion) {

			case 0:
				salir = true;
				System.out.println("Has salido del programa");
				break;
				
				//Crear Carpeta
				
			case 1:

				File carpeta = new File(ruta+directorio);

				if (carpeta.exists() == true) {
					System.out.println("La carpeta existe hombre, ¡¡ espabila !!");
					System.out.println();
				} else {
					carpeta.mkdir();
					System.out.println("Carpeta creada");
				}

				break;
				
				//Crear fichero
				
			case 2:
				
				File texto= new File(rutaFichero);
				
				if (texto.exists() == true) {
					System.out.println("El txt existe hombre, ¡¡ espabila !!");
					System.out.println();
				} else {
					try {
						BufferedWriter fw = new BufferedWriter(new FileWriter(rutaFichero));
						System.out.println("Archivo simulacro.txt creado correctamente.");
						for (String content : txt) {
							fw.write(content + "\n");
							fw.flush();
						}
						 fw.close(); // cierra BufferedWriter
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("Error");
					}
				}
				
				break;

			// Eliminar carpeta

			case 3:

				carpeta = new File(ruta+directorio);
				if (carpeta.exists() && carpeta.isDirectory()) {
					try {
						FileUtils.deleteDirectory(carpeta);
						System.out.println("La carpeta ha sido borrado con éxito");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("No se pudo borrar la carpeta");
					}
				} else {
					System.out.println("La carpeta no existe en la ubicación especificada");
				}

				break;

			// Eliminar txt

			case 4:

				texto = new File(rutaFichero);

				if (texto.exists()) {
					boolean borrado = texto.delete();
					if (borrado) {
						System.out.println("El fichero ha sido borrado con éxito");
					} else {
						System.out.println("No se pudo borrar el fichero " + rutaFichero);
					}
				} else {
					System.out.println("El fichero no existe en la ubicación especificada "+ rutaFichero);
				
				}

				break;
				
			case 5:

				File archivo = new File(rutaFichero);
				if (!archivo.exists()) {
					System.out.println("El archivo simulacro.txt no existe ");
					
				}
				try {
					FileReader fr = new FileReader(archivo);
					BufferedReader br = new BufferedReader(fr);
					String linea;
					while ((linea = br.readLine()) != null) {
						System.out.println(linea);
					}
					br.close();
					fr.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			}

		} while (!salir);

	}

}
