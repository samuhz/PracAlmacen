package almacen;

import java.util.Scanner;

/**
 * Clase de prueba de Almacen2
 * @author Samuel
 * @author Andres
 */

public class TestAlmacen2 {
	
	/**
	 * Método main, ejecuta los métodos de Almacen2
	 */
	static public void main(String[] argv) {

		Almacen2 prueba = new Almacen2();
		Scanner sc = new Scanner(System.in);
		int opcion;
		
		mostrarMenu();
		opcion = sc.nextInt();
		while (opcion != 0) {
			procesarOpcion(opcion, prueba, sc);
			mostrarMenu();
			opcion = sc.nextInt();
		}
		sc.close();

	}
	
	/**
	 * Método mostrarMenu que imprime por pantalla las diferentes opciones a elegir
	 */
	
	static void mostrarMenu() {
		System.out.println("--- MENÚ DE  CONTROL DEL ALMACÉN -----");
		System.out.println(" 1.- Mostrar contenido del Almacén");
		System.out.println(" 2.- Poner un Valor  ");
		System.out.println(" 3.- Buscar un Valor ");
		System.out.println(" 4.- Borrar un Valor");
		System.out.println(" 5.- Contar posiciones ocupadas.");
		System.out.println(" 6.- Contar posiciones libres.");
		System.out.println(" 0.- Terminar");
		System.out.print(" Introduzca una opción:[1-6]:");
	}

	/**
	 * Método que procesa y muestra la opción introducida operando sobre el objeto Almacen1
	 * @param opcion - parámetro que sirve para seleccionar que accion realizar 
	 * @param parAlmacen - parámetro que sirve para llamar a los métodos de Almacen1
	 * @param Scanner sc - parámetro que sirve para leer los valores
	 */
	
	static void procesarOpcion(int opcion, Almacen2 parAlmacen, Scanner sc) {
		switch (opcion) {
		case 1:
			System.out.println("Contenido del almacén " + parAlmacen.toString());
			break;
		case 2:
			System.out.println("Introduzca un valor");
			System.out.println("se ha introducido un valor: " + parAlmacen.ponValor(sc.nextInt()));
			break;
		case 3:
			System.out.println("Introduzca un valor");
			System.out.println("existe el valor: " + parAlmacen.estaValor(sc.nextInt()));
			break;
		case 4:
			System.out.println("Introduzca un valor");
			System.out.println(" se ha sacado un valor: " + parAlmacen.sacarValor(sc.nextInt()));
			break;
		case 5:
			System.out.println(" Posiciones ocupadas = " + parAlmacen.numPosicionesOcupadas());
			break;
		case 6:
			System.out.println(" Posiciones libres = " + parAlmacen.numPosicionesLibres());
			break;
		}
	}

}