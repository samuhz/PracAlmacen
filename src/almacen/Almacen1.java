package almacen;
import java.util.Arrays;

/*
 * Implementar un almacén de enteros mediante una tabla de huecos
 * se supone que no puede contener el valor 0 ya que indica posiciones libre.
 */
public class Almacen1 {

	static private final int LIBRE = 0;
	// Array con los valores almacenados
	private int tvalores[];
	private int valoresAlmacenados = 0;

	// Constructores sin parámetros creo una tabla de 10 elementos
	public Almacen1() {
		this(10); // Llamo al constructor con parámetros
	}

	// Constructor donde se fija tamaño máximo del Almacén
	public Almacen1(int tamaño) {
		tvalores = new int[tamaño];
		init();
	}

	// Pone todas las posiciones a LIBRES
	public void init() {
		for (int i = 0; i < tvalores.length; i++) {
			tvalores[i] = Almacen1.LIBRE;
		}
		valoresAlmacenados = 0;
	}

	// Muestra una cadena con los valores de la tabla
	public String toString() {
		return "Almacen1 [tvalores=" + Arrays.toString(tvalores) + ", valoresAlmacenados=" + valoresAlmacenados + "]";
	}

	// Devuelve el números de posiciones libres
	public int numPosicionesLibres() {

		return this.tvalores.length - this.valoresAlmacenados;
	}

	// Devuelve el número de posiones ocupadas
	public int numPosicionesOcupadas() {
		return this.valoresAlmacenados;
	}

	// Devuelve verdadero o falso si está almacenado el valor en la tabla
	public boolean estaValor(int num) {
		for (int i = 0; i < this.tvalores.length; i++) {
			if (this.tvalores[i] == num) {
				return true;
			}
		}
		return false;
	}

	// Almacena el valor el la tabla, devuelve false sin no puede almacenarlo
	public boolean ponValor(int num) {
		for (int i = 0; i < this.tvalores.length; i++) {
			if (this.tvalores[i] == LIBRE) {
				this.tvalores[i] = num;
				this.valoresAlmacenados++;
				return true;

			}
		}
		return false;
	}

	// Elimina el elemento de la tabla, si no esta devuelve false
	public boolean sacarValor(int num) {
		for (int j = 0; j <= this.tvalores.length; j++) {
			if (this.tvalores[j] == num) {
				this.tvalores[j] = LIBRE;
				this.valoresAlmacenados--;
				return true;
			}
		}
		return false;
	}

	// Indica si el almacén esta lleno
	public boolean estaLleno() {
		for (int s = 0; s <= this.tvalores.length; s++) {
			if (this.tvalores[s] == LIBRE) {
				return false;
			}
		}
		return true;
	}
}