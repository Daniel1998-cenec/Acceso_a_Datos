package menu;

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
		//String directorio="hola";
		//String nombreFichero = File.separator+"simulacro.txt";
		String txt[] = { "Hola buenas noches, soy tu padre" };
		//String rutaFichero = ruta + directorio + nombreFichero;
		boolean salir = false;
		String nombreCarpeta = null;
		String nombreFichero = null;
		String respuesta=null;
		do {

			// Menu para pedir cualquier accion mediante número.
			
			System.out.println(
					"Selecciona una opción:" + "\n\t 0 - Salir" + "\n\t 1 - Crear Carpeta" + "\n\t 2 - Crear Fichero"
							+ "\n\t 3 - Eliminar Carpeta" + "\n\t 4 - Eliminar fichero" + "\n\t 5 - Leer Fichero");

			opcion = Byte.parseByte(sc.nextLine());

			switch (opcion) {

			case 0:
				System.out.println("¿Estás seguro que quieres salir del programa?");
				String respuestaSalirPrograma=sc.nextLine();;
				if(respuestaSalirPrograma.equalsIgnoreCase("si")) {
					salir = true;
					System.out.println("Has salido del programa");
				}
				
				break;
				
				//Crea la Carpeta
				
			case 1:
				System.out.println("Dime el nombre que quieres que tenga la carpeta");
				nombreCarpeta=sc.nextLine();
				File carpeta = new File(ruta+nombreCarpeta);

				if (carpeta.exists() == true) {
					System.out.println("La carpeta existe hombre, ¡¡ espabila !!");
					System.out.println();
				} else {
					carpeta.mkdir();
					System.out.println("La carpeta "+nombreCarpeta+" ha sido creada correctamente");
				}

				break;
				
				//Crea el fichero
				
			case 2:
				System.out.println("Dime el nombre de la carpeta donde quieres que se guarde el txt");
				nombreCarpeta=sc.nextLine();
				System.out.println("Dime el nombre que quieres que tenga tu fichero");
				nombreFichero=sc.nextLine();
				File texto= new File(ruta+nombreCarpeta+File.separator+nombreFichero+".txt");
				
				if (texto.exists() == true) {
					System.out.println("El txt existe hombre, ¡¡ espabila !!");
					System.out.println();
				} else {
					try {
						System.out.println("¿Quieres que el txt tenga contenido?");
						respuesta=sc.nextLine();
						
						if(respuesta.equalsIgnoreCase("si")) {
							BufferedWriter fw = new BufferedWriter(new FileWriter(ruta+nombreCarpeta+File.separator+nombreFichero+".txt"));
							System.out.println("El txt tiene contenido");
							for (String content : txt) {
								fw.write(content + "\n");
								fw.flush();
							}
							 fw.close(); // cierra BufferedWriter
						}else {
							System.out.println("Has recalcado que no quieres que tenga contenido el txt.");
						}
						
						
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("Error " + ruta+nombreCarpeta+File.separator+nombreFichero+".txt");
					}
				}
				
				break;

			// Elimina la carpeta

			case 3:
				System.out.println("Dime el nombre de la carpeta donde quieres que se guarde el txt");
				nombreCarpeta=sc.nextLine();
				carpeta = new File(ruta+nombreCarpeta);
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

			// Elimina el txt

			case 4:
				System.out.println("Dime el nombre de la carpeta donde se guarde el txt");
				nombreCarpeta=sc.nextLine();
				System.out.println("Dime el nombre del fichero que quieres se borre");
				nombreFichero=sc.nextLine();
				texto = new File(ruta+nombreCarpeta+File.separator+nombreFichero+".txt");

				if (texto.exists()) {
					boolean borrado = texto.delete();
					if (borrado) {
						System.out.println("El fichero ha sido borrado con éxito");
					} else {
						System.out.println("No se pudo borrar el fichero " + ruta+nombreCarpeta+File.separator+nombreFichero+".txt");
					}
				} else {
					System.out.println("El fichero no existe en la ubicación especificada "+ ruta+nombreCarpeta+File.separator+nombreFichero+".txt");
				
				}

				break;
				
				//Te lee el contenido que tiene dentro el txt.
				
			case 5:
				System.out.println("Dime el nombre de la carpeta donde quieres que se guarde el txt");
				nombreCarpeta=sc.nextLine();
				System.out.println("Dime el nombre del fichero que quiere que lea");
				nombreFichero=sc.nextLine();
				File archivo = new File(ruta+nombreCarpeta+File.separator+nombreFichero+".txt");
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
