package ficheros.y.directorios;

import java.io.File;

public class BorrarFicheros6 {

	public static void main(String[] args) {
		String ruta = ".\\src\\main\\java\\ficheros\\y\\directorios\\VerInformacionFicheros.javaejercicio1";
		String nombreFichero = "fichero1.txt";

		String rutaFichero = ruta + File.separator + nombreFichero;

		File fichero = new File(rutaFichero);

		if (fichero.exists()) {
			boolean borrado = fichero.delete();
			if (borrado) {
				System.out.println("El fichero ha sido borrado con éxito");
			} else {
				System.out.println("No se pudo borrar el fichero");
			}
		} else {
			System.out.println("El fichero no existe en la ubicación especificada");
		}

	}

}
