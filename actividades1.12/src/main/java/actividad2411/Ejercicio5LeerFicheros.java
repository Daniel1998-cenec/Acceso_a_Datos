package actividad2411;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio5LeerFicheros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File archivo= new File(".\\src\\ficheros\\ciudades.txt");
		if (!archivo.exists()) {
			System.out.println("El archivo ciudades.txt existe");
			return;
		}
		
		try {
			FileReader fr = new FileReader(archivo);
			BufferedReader br= new BufferedReader(fr);
			
			String linea;
			while((linea= br.readLine()) !=null){
				System.out.println(linea);
			}
			
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
