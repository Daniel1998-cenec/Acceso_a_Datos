package actividad112;

import java.io.File;

public class CrearDirectorio3 {

	public static void main(String[] args) {
		String ruta = ".\\src";
		String carpeta = "ejercicio1";
		File directorio = new File(ruta + carpeta);
		if (directorio.exists() == true) {
			System.out.println("La carpeta existe hombre mayor de gustos lésbicos");
		} else {
			directorio.mkdir();
			System.out.println("Carpeta creada");
		}

	}

}
