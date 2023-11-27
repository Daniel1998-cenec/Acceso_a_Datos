package ficheros.y.directorios;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class BorrarCarpeta7 {

	public static void main(String[] args) {
		File carpeta = new File(".\\src\\main\\java\\ficheros\\y\\directorios\\VerInformacionFicheros.javaejercicio1");

		if (carpeta.exists() && carpeta.isDirectory()) {
			System.out.println("El directorio existe");
			try {
				FileUtils.deleteDirectory(carpeta);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("El directorio ha sido borrado");
		} else {
			System.out.println("El directorio no existe o no es un directorio");
		}

	}

}
