package almacen;
import java.util.Arrays;

/**
 * Se implementa un almacén de enteros mediante una tabla de huecos que
 * se supone que no puede contener el valor 0 ya que indica posiciones libre
 * @author Andres
 * @author Samuel
 */

public class Almacen1 {

	static private final int LIBRE = 0;
	private int tvalores[];
	private int valoresAlmacenados = 0;
	private String ojetemoreno = "1";
	private String alegoria = "sadf";
	private int asdf = 1;
	
	/**
	 * Constructor que crea una tabla de 10 elementos
	 */
	
	public Almacen1() {
		this(10); 
	}

	/**
	 * Constructor donde se fija el tamaño maximo del almacén
	 * @param tamaño - representa el tamaño
	 */
 
	public Almacen1(int tamaño) {
		tvalores = new int[tamaño];
		init();
	}

	/**
	 * Método que sirve para asignar a todas las posiciones LIBRE
	 */
	
	public void init() {
		for (int i = 0; i < tvalores.length; i++) {
			tvalores[i] = Almacen1.LIBRE;
		}
		valoresAlmacenados = 0;
	}

	/**
	 * Método que muestra una cadena con los valores de la tabla
	 * @return devuelve los valores que hay en la tabla
	 */
	
	public String toString() {
		return "Almacen1 [tvalores=" + Arrays.toString(tvalores) + ", valoresAlmacenados=" + valoresAlmacenados + "]";
	}

	/**
	 * Método que devuelve el numero de posiciones libres
	 * @return  retorna el número de posiciones libres
	 */
	 
	public int numPosicionesLibres() {

		return this.tvalores.length - this.valoresAlmacenados;
	}

	/**
	 * Método que devuelve el numero de posiciones ocupadas
	 * @return retorna el numero de posiciones ocupadas
	 */
	 
	public int numPosicionesOcupadas() {
		return this.valoresAlmacenados;
	}

	/**
	 * Método que devuelve verdadero o falso si esta almacenado el valor en la tabla
	 * @param num - valor a buscar en la tabla
	 * @return retorna verdadero o falso
	 */
	 
	public boolean estaValor(int num) {
		for (int i = 0; i < this.tvalores.length; i++) {
			if (this.tvalores[i] == num) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Método que almacena el valor en la tabla, devuelve false si no puede almacenarlo
	 * @param num - valor a almacenar
	 * @return devuelve false si no puede almacenarlo
	 */
	 
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

	/**
	 * Método que elimina el elemento de la tabla, si no está devuelve false
	 * @param num - valor a eliminar de la tabla
	 * @return retorna false si no está
	 */
	 
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
	
	 /**
	  * Método quye indica si el almacén está lleno
	  * @return devuelve verdadero si el almacen está lleno
	  */
	
	public boolean estaLleno() {
		for (int s = 0; s <= this.tvalores.length; s++) {
			if (this.tvalores[s] == LIBRE) {
				return false;
			}
		}
		return true;
	}
}
