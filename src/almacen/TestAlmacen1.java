package almacen;

// Clase de prueba COMPLETAR EL CÓDIGO DEL MÉTODO procesar Opción 
import java.util.Scanner;

public class TestAlmacen1 {

	static public void main(String[] argv) {

		Almacen1 prueba = new Almacen1();
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

	// Procesa la opción introducida operando sobre el objeto Almacen1
	static void procesarOpcion(int opcion, Almacen1 parAlmacen, Scanner sc) {
		// Completar......
//		Scanner sc = new Scanner(System.in);
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
//		sc.close();

	}

}