package ejercicio.opcional;

import java.util.List;


public class VideojuegoView {
	
	public void mostrarVideojuego(List<Videojuego> videojuegos) {
		
		for (Videojuego videojuego : videojuegos) {
            System.out.println("IDVideoJuego: " + videojuego.getIdjuego()); // Imprime el ID del videojuego
            System.out.println("nombre: " + videojuego.getNombre()); // Imprime el nombre del videojuego
            System.out.println("Año: " + videojuego.getAnio()); // Imprime el año del videojuego
            System.out.println("Compañía: " + videojuego.getCompania()); // Imprime la compañia del videojuego
            System.out.println("Precio: "+videojuego.getPrecio());//Imprime el precio del videojuego
            System.out.println("Sinopsis: "+videojuego.getSinopsis());//Imprime la sinopsis del videojuego
            System.out.println("Plataforma: "+videojuego.getPlataforma());//Imprime la plataforma del videojuego
            System.out.println(); // Imprime una línea en blanco para separar los clientes
        }
		
	}
}
